package com.example.currencyrates.controller.impl;

import com.example.currencyrates.controller.api.OpenExchangeController;
import com.example.currencyrates.service.api.ExchangeRatesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class OpenExchangeControllerImpl implements OpenExchangeController {

  private final ExchangeRatesService ratesService;

  @Override
  public String getRates(Model model) {
    String url = ratesService.getActualGifImage();
    model.addAttribute("url",url);
    return "main";
  }
}
