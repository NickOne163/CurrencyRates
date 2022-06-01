package com.example.currencyrates;

import com.example.currencyrates.openfeign.GiphyFeign;
import com.example.currencyrates.openfeign.OpenExchangeFeign;
import com.example.currencyrates.service.impl.ExchangeRatesServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.currencyrates.utils.TestUtils.getDefaultHighCourseResponse;
import static com.example.currencyrates.utils.TestUtils.getDefaultLowCourseResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ExchangeRatesServiceTest {

  @Value("${giphyId}")
  private String giphyId;

  @MockBean
  private GiphyFeign giphyFeign;

  @MockBean
  private OpenExchangeFeign exchangeFeign;

  @InjectMocks
  @Autowired
  private ExchangeRatesServiceImpl service;

  @Test
  void shouldReturnRichGifWhenRateRise() {
    //given
    when(exchangeFeign.getYesterdayCurrencies(any(), any()))
      .thenReturn(getDefaultLowCourseResponse());
    when(exchangeFeign.getLatestCurrencies(any(), any()))
      .thenReturn(getDefaultHighCourseResponse());
    //when
    service.getActualGifImage();
    //then
    verify(giphyFeign, times(1)).getGifByTag(giphyId, "Rich");
    verify(giphyFeign, times(0)).getGifByTag(giphyId, "Broke");
  }

  @Test
  void shouldReturnBrokeGifWhenRateFall() {
    //given
    when(exchangeFeign.getYesterdayCurrencies(any(), any()))
      .thenReturn(getDefaultHighCourseResponse());
    when(exchangeFeign.getLatestCurrencies(any(), any()))
      .thenReturn(getDefaultLowCourseResponse());
    //when
    service.getActualGifImage();
    //then
    verify(giphyFeign, times(0)).getGifByTag(giphyId, "Rich");
    verify(giphyFeign, times(1)).getGifByTag(giphyId, "Broke");
  }
}

