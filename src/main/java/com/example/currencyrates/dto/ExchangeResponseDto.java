package com.example.currencyrates.dto;

import lombok.Data;

import java.util.Map;

@Data
public class ExchangeResponseDto {

  Map<String,String> rates;
}
