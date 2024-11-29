package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeResponseDto {

    private String userName;
    private String currencyName;
    private BigDecimal amountInKw;
    private BigDecimal amountAfterExchage;

    public ExchangeResponseDto(Exchange exchange) {
        this.userName= exchange.getUser().getName();
        this.currencyName = exchange.getCurrency().getCurrencyName();
        this.amountInKw = exchange.getAmountInKrw();
        this.amountAfterExchage = exchange.getAmountAfterExchange();
    }

}
