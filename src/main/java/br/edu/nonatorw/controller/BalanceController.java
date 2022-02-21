package br.edu.nonatorw.controller;

import br.edu.nonatorw.service.BalanceService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping(path = "/demo")
public class BalanceController {
    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    /**
     * gets balance for all currencies
     *
     * @return map with currencies with balance bigger than 0
     */
    @GetMapping(path = "/balance")
    public @ResponseBody
    Map<String, BigDecimal> balance() {
        return balanceService.getBalance();
    }

    /**
     * gets net balance for all currencies
     *
     * @return map with currencies with net balance bigger than 0
     */
    @GetMapping(path = "/net/balance")
    public @ResponseBody
    Map<String, BigDecimal> netBalance() {
        return balanceService.getNetBalance();
    }

    /**
     * gets usd balance
     *
     * @return
     */
    @GetMapping(path = "/usd/balance")
    public @ResponseBody
    BigDecimal usdBalance() {
        return balanceService.getUSDBalance();
    }

    /**
     * gets balance for one currency
     *
     * @return balance
     */
    @GetMapping(path = "/balance/{currency}")
    public @ResponseBody
    BigDecimal getBalance(@PathVariable String currency) {
        return balanceService.getBalanceForCurrency(currency);
    }

}
