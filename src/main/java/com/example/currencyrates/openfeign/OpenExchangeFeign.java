package com.example.currencyrates.openfeign;


import com.example.currencyrates.dto.ExchangeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(name = "exchangeService", url = "${openExchangeUrl}")
public interface OpenExchangeFeign {

  @GetMapping("/latest.json")
  ResponseEntity<ExchangeResponseDto> getLatestCurrencies(@RequestParam("app_id") String id,
                                                          @RequestParam("symbols") String symbols);

  @GetMapping("historical/{date}.json")
  ResponseEntity<ExchangeResponseDto> getYesterdayCurrencies(
    @PathVariable  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date,
    @RequestParam("app_id") String id);
}
