package com.example.currencyrates;

import com.example.currencyrates.controller.api.OpenExchangeController;
import com.example.currencyrates.service.api.ExchangeRatesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OpenExchangeController.class)
class OpenExchangeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ExchangeRatesService service;

  @Test
  void canGetGifImage() throws Exception {
    String expected = "gif";
    Mockito.when(service.getActualGifImage()).thenReturn(expected);
    this.mockMvc.perform(get("/currency/get"))
      .andExpect(status().isOk())
      .andExpect(content().string(containsString(expected)));
  }
}
