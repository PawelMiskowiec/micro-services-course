package com.in28minutes.currencyexchange.controller;

import com.in28minutes.currencyexchange.entity.CurrencyExchange;
import com.in28minutes.currencyexchange.repo.CurrencyExchangeJpaRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyExchangeJpaRepository currencyExchangeRepository;
    private final Environment environment;

    @GetMapping("/currency-exchange")
    public List<CurrencyExchange> getAll(){
        return currencyExchangeRepository.findAll();
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
        @PathVariable String from, @PathVariable String to
    ){
        CurrencyExchange response = currencyExchangeRepository.findByFromAndTo(from, to)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "Cannot find requested whatever this example is weird:)")
            );
        response.setEnvironment(environment.getProperty("local.server.port"));
        return response;
    }
}
