package com.sparta.currency_user.dto;

import com.sparta.currency_user.entity.Exchange;
import lombok.Getter;

@Getter
public class CancelExchangeRequestDto {
    private Long exchangeId;
    private Exchange.Status status;

    CancelExchangeRequestDto(Long exchangeId, Exchange.Status status) {
        this.exchangeId = exchangeId;
        this.status = status;
    }
}
