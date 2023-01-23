package com.in28minutes.limitsservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("limits-service")
@org.springframework.context.annotation.Configuration
public class Configuration {
    private int min;
    private int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
