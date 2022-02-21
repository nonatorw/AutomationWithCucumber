package br.edu.nonatorw.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.math.BigDecimal;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesWithJavaConfig {

    @Value("#{${trade.fees}}")
    private Map<String, BigDecimal> tradeFees;

    public Map<String, BigDecimal> getTradeFees() {
        return tradeFees;
    }
}