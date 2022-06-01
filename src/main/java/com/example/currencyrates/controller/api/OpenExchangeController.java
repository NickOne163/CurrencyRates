package com.example.currencyrates.controller.api;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/currency")
public interface OpenExchangeController {

  @GetMapping("/get")
  String getRates(Model model);
}
