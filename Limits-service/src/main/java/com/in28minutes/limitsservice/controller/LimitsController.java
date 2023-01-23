package com.in28minutes.limitsservice.controller;

import com.in28minutes.limitsservice.configuration.Configuration;
import com.in28minutes.limitsservice.domain.Limits;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retrieveLimits() {
        return new Limits(configuration.getMin(), configuration.getMax());
    }
}
