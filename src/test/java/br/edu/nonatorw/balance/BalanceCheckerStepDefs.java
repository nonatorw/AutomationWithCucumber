package br.edu.nonatorw.balance;

import br.edu.nonatorw.config.PropertiesWithJavaConfig;
import br.edu.nonatorw.service.BalanceService;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static com.fasterxml.jackson.databind.DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS;

public class BalanceCheckerStepDefs {
    private final Logger log = LoggerFactory.getLogger(BalanceCheckerStepDefs.class);

    @LocalServerPort
    private int port;
    private static final String BASE_URL = "http://localhost";
    private static final String BASE_PATH = "/demo";

    private Response response;

    @Autowired
    private PropertiesWithJavaConfig props;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Map<String, BigDecimal> balanceRef;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Map<String, BigDecimal> tmpBalance;

    private BigDecimal amount;

    private Response getResponse(String path) {
        RequestSpecification request = RestAssured.given()
                .baseUri(BASE_URL)
                .port(port)
                .basePath(BASE_PATH);
        request.header("Content-Type", "application/json");
        response = request.get(path);

        return response;
    }

    private ObjectMapper getJsonParsed() {
        ObjectMapper objM = new ObjectMapper();
        objM = objM.configure(USE_BIG_DECIMAL_FOR_FLOATS, true);
        objM = objM.setNodeFactory(JsonNodeFactory.withExactBigDecimals(true));

        return objM;
    }

    @SneakyThrows
    @Given("A list of balances can be retrieved")
    public void aListOfBalancesCanBeRetrieved() {
        Response response = getResponse("/balance");
        String jsonBody = response.asString();
        ObjectMapper objM = getJsonParsed();
        balanceRef = objM.readValue(jsonBody, Map.class);
    }

    @SneakyThrows
    @When("I want to know all my balances in every currency that I have")
    public void iWantToKnowAllMyBalancesInEveryCurrencyThatIHave() {
        String s = getResponse("/balance").asString();
        ObjectMapper objM = getJsonParsed();
        tmpBalance = objM.readValue(s, Map.class);
        Assertions.assertThat(tmpBalance).isIn(balanceRef);
    }

    @Then("there are only balances greater than zero")
    public void thereAreOnlyBalancesGreaterThanZero() {
        tmpBalance.values().stream().forEach(v ->
                Assertions.assertThat(v)
                        .as("There are only balances greater than Zero.")
                        .usingComparator(BigDecimal::compareTo)
                        .isGreaterThan(BigDecimal.ZERO)
                        .withFailMessage("ERROR: There is balances with value lesser than zero!"));
    }

    @SneakyThrows
    @When("I want to know the total balance amount I have,")
    public void iWantToKnowTheTotalBalanceAmountIHave() {
        String s = getResponse("/usd/balance").asString();
        ObjectMapper objM = getJsonParsed();
        amount = objM.readValue(s, BigDecimal.class);
    }

    @SneakyThrows
    @Then("that amount needs to be converted to USD \\(currency)")
    public void thatAmountNeedsToBeConvertedToUSDCurrency() {
        String s = getResponse("/balance").asString();
        ObjectMapper objM = getJsonParsed();
        tmpBalance = objM.readValue(s, Map.class);

        BigDecimal sum = tmpBalance.values().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        Assertions.assertThat(amount.equals(sum.multiply(BalanceService.USD_RATE)))
                .as("The Balance amount are in USD.")
                .isTrue()
                .withFailMessage("ERROR: The total amount is not in USD!");
    }

    @SneakyThrows
    @When("I want to know the total amount I have for a specific currency as {string},")
    public void i_want_to_know_the_total_amount_i_have_for_a_specific_currency_as(String string) {
        String s = getResponse("/balance/" + string).asString();
        ObjectMapper objM = getJsonParsed();
        amount = objM.readValue(s, BigDecimal.class);
    }

    @Then("I should receive the total amount I have for that currency as {string}")
    public void iShouldReceiveTheTotalAmountIHaveForThatCurrency(String currency) {
        Assertions.assertThat(balanceRef.containsKey(currency) == Boolean.TRUE && balanceRef.get(currency).equals(amount))
                .as("The total amount I have for that currency")
                .isTrue()
                .withFailMessage("ERROR: the amount returned for this currency is not the real one I have!");
    }

    @SneakyThrows
    @When("I want to know all my balances minus fee,")
    public void iWantToKnowAllMyBalancesMinusFee() {
        Map<String, BigDecimal> newBalance = new HashMap<>();
        Map<String, BigDecimal> fees = props.getTradeFees();
        ObjectMapper objM = getJsonParsed();

        String s = getResponse("/net/balance").asString();
        tmpBalance = objM.readValue(s, Map.class);

        balanceRef.forEach((key, value) ->
                newBalance.put(key, value.subtract(fees.getOrDefault(key, BigDecimal.ZERO))));

        Assertions.assertThat(tmpBalance.equals(newBalance))
                .as("The Net Balance needs to be balance minus fee")
                .isTrue()
                .withFailMessage("ERROR: to recover Net Balance!");
    }
}
