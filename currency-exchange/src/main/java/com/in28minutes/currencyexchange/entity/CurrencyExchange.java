package com.in28minutes.currencyexchange.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyExchange {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "currency_from")
    private String from;
    @Column(name = "currency_to")
    private String to;
    private BigDecimal conversionMultiplier;
    private String environment;

    public CurrencyExchange(Long id, String from, String to, BigDecimal conversionMultiplier) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiplier = conversionMultiplier;
    }
}
