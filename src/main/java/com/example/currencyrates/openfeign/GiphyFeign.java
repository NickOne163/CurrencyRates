package com.example.currencyrates.openfeign;


import com.example.currencyrates.dto.GiphyResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "giphyService", url = "${giphyUrl}")
public interface GiphyFeign {

  @GetMapping
  ResponseEntity<Map<String, GiphyResponseDto>> getGifByTag(@RequestParam("api_key") String key,
                                                            @RequestParam("tag") String tag);
}
