package com.sparta.currency_user.service;

import com.sparta.currency_user.dto.CancelExchangeRequestDto;
import com.sparta.currency_user.dto.CreateExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.ReadExchangeResponseDto;
import com.sparta.currency_user.entity.Currency;
import com.sparta.currency_user.entity.Exchange;
import com.sparta.currency_user.entity.User;
import com.sparta.currency_user.repository.CurrencyRepository;
import com.sparta.currency_user.repository.ExchangeRepository;
import com.sparta.currency_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;

    public ExchangeResponseDto save(CreateExchangeRequestDto exchangeRequestDto) {
        User user = userRepository.getByEmail(exchangeRequestDto.getUserEmail());
        Currency currency = currencyRepository.getByCurrencyName(exchangeRequestDto.getCurrencyName());

        BigDecimal afterExchage = exchangeRequestDto.getAmountInKw().divide(currency.getExchangeRate(), 2, RoundingMode.DOWN);

        Exchange exchange = Exchange.builder()
                .user(user)
                .currency(currency)
                .amountInKrw(exchangeRequestDto.getAmountInKw())
                .amountAfterExchange(afterExchage).build();

        Exchange saveExchange = exchangeRepository.save(exchange);

        return new ExchangeResponseDto(saveExchange);
    }

    public List<ReadExchangeResponseDto> readExchanges(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);

        List<Exchange> exchanges = exchangeRepository.findAllByUser(user);

        return exchanges.stream().map(ReadExchangeResponseDto::new).toList();

    }

    public void cancelExchange(CancelExchangeRequestDto cancelExchangeDto) {
        Exchange exchange = exchangeRepository.findByIdOrElseThrow(cancelExchangeDto.getExchangeId());

        exchange.update_status(cancelExchangeDto.getStatus());
    }


}
