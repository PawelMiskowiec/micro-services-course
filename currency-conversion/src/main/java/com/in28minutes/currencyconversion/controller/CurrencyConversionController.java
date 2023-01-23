package com.in28minutes.currencyconversion.controller;

import com.in28minutes.currencyconversion.entity.CurrencyConversion;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CurrencyConversionController {
    private final CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
        @PathVariable String from,
        @PathVariable String to,
        @PathVariable BigDecimal quantity
        ){
        CurrencyConversion currencyConversion =
            currencyExchangeProxy.retrieveExchangeValue(from, to);
        currencyConversion.setQuantity(quantity);
        currencyConversion.setTotalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiplier()));
        return currencyConversion;
    }
}
