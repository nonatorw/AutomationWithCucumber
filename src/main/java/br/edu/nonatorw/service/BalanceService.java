package br.edu.nonatorw.service;

import br.edu.nonatorw.config.PropertiesWithJavaConfig;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class BalanceService {
    public static final BigDecimal USD_RATE = new BigDecimal("0.23665485");

    private final PropertiesWithJavaConfig properties;

    public BalanceService(PropertiesWithJavaConfig properties) {
        this.properties = properties;
    }

    public Map<String, BigDecimal> getBalance() {
        return new HashMap<String, BigDecimal>() {{
            put("ACM", new BigDecimal("0.0000000"));
            put("ADA", new BigDecimal("0.0000000"));
            put("AEON", new BigDecimal("0.0000000"));
            put("ARQ", new BigDecimal("0.0000000"));
            put("ARRR", new BigDecimal("0.0000000"));
            put("AVN", new BigDecimal("0.0000000"));
            put("BBS", new BigDecimal("0.0000000"));
            put("BCN", new BigDecimal("0.0000000"));
            put("BEAM", new BigDecimal("0.0000000"));
            put("BITC", new BigDecimal("0.0000000"));
            put("BKC", new BigDecimal("0.0000000"));
            put("BLKC", new BigDecimal("0.0000000"));
            put("BLOC", new BigDecimal("0.0000000"));
            put("BTC", new BigDecimal("0.000000011"));
            put("BTCP", new BigDecimal("0.0000000"));
            put("CASH", new BigDecimal("0.0000000"));
            put("CCX", new BigDecimal("0.9990000"));
            put("CIV", new BigDecimal("0.0000000"));
            put("CLOAK", new BigDecimal("0.0000000"));
            put("COAL", new BigDecimal("0.0000000"));
            put("CUT", new BigDecimal("0.0000000"));
            put("D", new BigDecimal("0.0000000"));
            put("DASH", new BigDecimal("0.0000000"));
            put("DERO", new BigDecimal("0.0000000"));
            put("DOGE", new BigDecimal("0.0000000"));
            put("ERG", new BigDecimal("0.0000000"));
            put("ETH", new BigDecimal("0.0000000"));
            put("ETN", new BigDecimal("0.0000000"));
            put("ETNX", new BigDecimal("0.0000000"));
            put("ETNXP", new BigDecimal("0.0000000"));
            put("FBF", new BigDecimal("0.0000000"));
            put("FLUX", new BigDecimal("0.0000000"));
            put("GHOST", new BigDecimal("0.0000000"));
            put("GPKR", new BigDecimal("0.0000000"));
            put("GRFT", new BigDecimal("0.0000000"));
            put("GRIMM", new BigDecimal("0.0000000"));
            put("GRIN", new BigDecimal("0.0000000"));
            put("GRLC", new BigDecimal("0.0000000"));
            put("INC", new BigDecimal("0.0000000"));
            put("INTU", new BigDecimal("0.0000000"));
            put("IRD", new BigDecimal("2.8820000"));
            put("KDA", new BigDecimal("0.00000000"));
            put("KRB", new BigDecimal("0.0000000"));
            put("LNS", new BigDecimal("0.0000000"));
            put("LTC", new BigDecimal("0.0000000"));
            put("LTHN", new BigDecimal("5.2012235"));
            put("LUX", new BigDecimal("0.0000000"));
            put("MAT", new BigDecimal("0.0000000"));
            put("MSR", new BigDecimal("0.0000000"));
            put("MWC", new BigDecimal("0.0000000"));
            put("NAH", new BigDecimal("0.0000000"));
            put("NANO", new BigDecimal("0.0000000"));
            put("NBR", new BigDecimal("0.0000000"));
            put("NCP", new BigDecimal("0.0000000"));
            put("OMB", new BigDecimal("0.0000000"));
            put("ONION", new BigDecimal("0.0000000"));
            put("OXEN", new BigDecimal("0.0000000"));
            put("PCN", new BigDecimal("0.0000000"));
            put("PIVX", new BigDecimal("0.0000000"));
            put("PLURA", new BigDecimal("0.0000000"));
            put("POT", new BigDecimal("0.0000000"));
            put("PRCY", new BigDecimal("0.0000000"));
            put("PURK", new BigDecimal("0.0000000"));
            put("QTUM", new BigDecimal("0.0000000"));
            put("QUAN", new BigDecimal("0.0000000"));
            put("RTM", new BigDecimal("0.0000000"));
            put("RTO", new BigDecimal("60.9700000"));
            put("RVN", new BigDecimal("0.0000000"));
            put("RYO", new BigDecimal("0.0000000"));
            put("SHB", new BigDecimal("0.0000000"));
            put("SIN", new BigDecimal("0.0000000"));
            put("SLD", new BigDecimal("0.0000000"));
            put("SOLACE", new BigDecimal("0.0000000"));
            put("SUMO", new BigDecimal("0.0000000"));
            put("TRTL", new BigDecimal("0.0000000"));
            put("TUBE", new BigDecimal("0.0000000"));
            put("UNI", new BigDecimal("0.0000000"));
            put("UPX", new BigDecimal("5548.3800000"));
            put("USDT", new BigDecimal("0.0000000"));
            put("VEIL", new BigDecimal("0.0000000"));
            put("WAE", new BigDecimal("0.0000000"));
            put("WOW", new BigDecimal("0.0000000"));
            put("WTIP", new BigDecimal("138.6000000"));
            put("XAO", new BigDecimal("0.0000000"));
            put("XEQ", new BigDecimal("0.0000000"));
            put("XGM", new BigDecimal("0.0000000"));
            put("XGS", new BigDecimal("0.0000000"));
            put("XHV", new BigDecimal("0.1013500"));
            put("XLA", new BigDecimal("0.0000000"));
            put("XMC", new BigDecimal("0.0000000"));
            put("XMR", new BigDecimal("0.0063641"));
            put("XMV", new BigDecimal("0.0000000"));
            put("XNV", new BigDecimal("0.0000000"));
            put("XPP", new BigDecimal("0.0000000"));
            put("XRN", new BigDecimal("0.0000000"));
            put("XRP", new BigDecimal("0.0000000"));
            put("XTA", new BigDecimal("0.0000000"));
            put("XTNC", new BigDecimal("0.0000000"));
            put("XUN", new BigDecimal("0.0000000"));
            put("XUSD", new BigDecimal("0.0000000"));
            put("XVG", new BigDecimal("0.0000000"));
            put("XWP", new BigDecimal("0.0000000"));
            put("ZANO", new BigDecimal("0.0000000"));
        }};
    }

    public Map<String, BigDecimal> getNetBalance() {
        final Map<String, BigDecimal> tradeFees = properties.getTradeFees();
        Map<String, BigDecimal> balance = getBalance();
        Map<String, BigDecimal> newBalance = new HashMap<>();
        balance.forEach((key, value) -> newBalance.put(key, value.subtract(tradeFees.getOrDefault(key, BigDecimal.ZERO))));
        return newBalance;
    }

    private Map<String, BigDecimal> removeNegativeAndZeroBalances(Map<String, BigDecimal> balance) {
        Map<String, BigDecimal> newBalance = new HashMap<>();
        balance.forEach((s, bigDecimal) -> {
            if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                newBalance.put(s, bigDecimal);
            }
        });
        return newBalance;
    }

    public BigDecimal getBalanceForCurrency(String currency) {
        BigDecimal bigDecimal = getBalance().get(currency);
        if (null == bigDecimal)
            throw new RuntimeException(currency + " not valid");
        return bigDecimal;
    }

    public BigDecimal getUSDBalance() {
        Map<String, BigDecimal> balance = getBalance();
        final BigDecimal[] sum = {BigDecimal.ZERO};
        balance.forEach((s, bigDecimal) -> sum[0] = sum[0].add(bigDecimal.multiply(USD_RATE)));
        return sum[0];
    }
}
