package com.in28minutes.currencyexchange.repo;

import com.in28minutes.currencyexchange.entity.CurrencyExchange;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeJpaRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findByFromAndTo(String from, String to);
}
