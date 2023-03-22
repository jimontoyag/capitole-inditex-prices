package com.jimontoyag.capitole.inditexprices.service;

import com.jimontoyag.capitole.inditexprices.model.Price;

import java.time.Instant;
import java.util.Optional;

public interface PriceService {

    Optional<Price> finalPrice(Instant date, long productId, long brandId);
}
