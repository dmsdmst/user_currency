package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ReadExchangeResponseDto {
    private BigDecimal amountInKw;
    private String currencyName;
    private BigDecimal amountAfterExchange;
    private LocalDateTime createAt;

    public ReadExchangeResponseDto(BigDecimal amountInKw, String currencyName, BigDecimal amountAfterExchange, LocalDateTime createAt) {
        this.amountInKw = amountInKw;
        this.currencyName = currencyName;
        this.amountAfterExchange = amountAfterExchange;
        this.createAt = createAt;
    }

    public ReadExchangeResponseDto(Exchange exchange) {
        this.amountInKw = exchange.getAmountInKrw();
        this.currencyName = exchange.getCurrency().getCurrencyName();
        this.amountAfterExchange = exchange.getAmountAfterExchange();
        this.createAt = exchange.getCreatedAt();
    }
    public static ReadExchangeResponseDto toDto(Exchange exchange) {
        return new ReadExchangeResponseDto(
                exchange.getAmountInKrw(),
                exchange.getCurrency().getCurrencyName(),
                exchange.getAmountAfterExchange(),
                exchange.getCreatedAt()
        );
    }
}
