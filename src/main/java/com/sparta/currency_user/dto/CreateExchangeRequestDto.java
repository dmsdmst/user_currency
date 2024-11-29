package com.sparta.currency_user.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class CreateExchangeRequestDto {

    private String userEmail;
    private String currencyName;
    private BigDecimal amountInKw;


    public CreateExchangeRequestDto(String userEmail, String currencyName, BigDecimal amountInKw) {
        this.userEmail = userEmail;
        this.currencyName = currencyName;
        this.amountInKw = amountInKw;
    }
}
