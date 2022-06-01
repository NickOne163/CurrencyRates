package com.example.currencyrates.service.impl;

import com.example.currencyrates.dto.GiphyResponseDto;
import com.example.currencyrates.openfeign.GiphyFeign;
import com.example.currencyrates.openfeign.OpenExchangeFeign;
import com.example.currencyrates.service.api.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ExchangeRatesServiceImpl implements ExchangeRatesService {

  private final OpenExchangeFeign exchangeRatesFeign;
  private final GiphyFeign giphyFeign;

  @Value("${exchangeRatesId}")
  private String exchangeId;

  @Value("${giphyId}")
  private String giphyId;

  @Value("${symbols}")
  private String currency;

  @Override
  public String getActualGifImage() {
    double yesterdayRates = getYesterdayCurrencyRates();
    double todayRates = getTodayCurrencyRates();
    ResponseEntity<Map<String, GiphyResponseDto>> response;
    if(todayRates > yesterdayRates) {
      response = giphyFeign.getGifByTag(giphyId, "Rich");
    } else {
      response = giphyFeign.getGifByTag(giphyId, "Broke");
    }
    return response!=null
      ? response.getBody().get("data").getImages().get("original").get("url")
      : getErrorGifUrl();
  }

  @Override
  public double getYesterdayCurrencyRates() {
    return Double.parseDouble(Objects.requireNonNull(exchangeRatesFeign
        .getYesterdayCurrencies(LocalDate.now().minusDays(1), exchangeId)
        .getBody())
      .getRates()
      .get(currency));
  }

  @Override
  public double getTodayCurrencyRates() {
    return Double.parseDouble(Objects.requireNonNull(exchangeRatesFeign
        .getLatestCurrencies(exchangeId, currency)
        .getBody())
      .getRates()
      .get(currency));
  }

  @Override
  public String getErrorGifUrl() {
    return "https://i.giphy.com/media/1RkDDoIVs3ntm/giphy.webp";
  }

}
