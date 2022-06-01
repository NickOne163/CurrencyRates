package com.example.currencyrates.dto;

import lombok.Data;

import java.util.Map;

@Data
public class GiphyResponseDto {
  String url;
  Map<String,Map<String,String>> images;
}
