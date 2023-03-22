package com.jimontoyag.capitole.inditexprices.controller;

import com.jimontoyag.capitole.inditexprices.controller.dto.FinalPriceDTO;
import com.jimontoyag.capitole.inditexprices.controller.mapper.PriceControllerMapper;
import com.jimontoyag.capitole.inditexprices.service.PriceService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;

@RestController
@RequestMapping("prices")
public class PriceController {

  private final PriceService priceService;
  private final PriceControllerMapper mapper;

  public PriceController(PriceService priceService, PriceControllerMapper mapper) {
    this.priceService = priceService;
    this.mapper = mapper;
  }

  @GetMapping("final-price")
  public FinalPriceDTO lookForFinalPrice(Instant date, long product, long brand) {
    return mapper.priceModelToDTO(
        priceService
            .finalPrice(date, product, brand)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
  }
}
