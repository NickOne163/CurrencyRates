package com.example.currencyrates.utils;

import com.example.currencyrates.dto.ExchangeResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class TestUtils {

  public static ResponseEntity<ExchangeResponseDto> getDefaultLowCourseResponse() {
    ExchangeResponseDto responseDto = new ExchangeResponseDto();
    Map<String,String> rates = Map.of("RUB","35.5");
    responseDto.setRates(rates);
    return new ResponseEntity<>(responseDto, HttpStatus.OK);

  }
   public static ResponseEntity<ExchangeResponseDto> getDefaultHighCourseResponse() {
     ExchangeResponseDto responseDto = new ExchangeResponseDto();
     Map<String,String> rates = Map.of("RUB","88.8");
     responseDto.setRates(rates);
     return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }
}
