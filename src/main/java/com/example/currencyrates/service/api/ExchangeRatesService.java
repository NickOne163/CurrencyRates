package com.example.currencyrates.service.api;

public interface ExchangeRatesService {

  String getActualGifImage();

  double getYesterdayCurrencyRates();

  double getTodayCurrencyRates();

  String getErrorGifUrl();
}
