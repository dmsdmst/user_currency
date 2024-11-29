package com.sparta.currency_user.controller;

import com.sparta.currency_user.dto.CancelExchangeRequestDto;
import com.sparta.currency_user.dto.CreateExchangeRequestDto;
import com.sparta.currency_user.dto.ExchangeResponseDto;
import com.sparta.currency_user.dto.ReadExchangeResponseDto;
import com.sparta.currency_user.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;


    @PostMapping
    public ResponseEntity<ExchangeResponseDto> requestCurrency(@RequestBody CreateExchangeRequestDto createExchangeRequestDto){
        return ResponseEntity.ok().body(exchangeService.save(createExchangeRequestDto));
    }


    @GetMapping("/{id}")
    public ResponseEntity<List<ReadExchangeResponseDto>> readExchanges(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(exchangeService.readExchanges(id));
    }

    @PatchMapping
    public ResponseEntity<String> cancelExchange(@RequestBody CancelExchangeRequestDto cancelExchangeDto) {
        exchangeService.cancelExchange(cancelExchangeDto);
        return ResponseEntity.ok().body("요청이 취소되었습니다");
    }



}
