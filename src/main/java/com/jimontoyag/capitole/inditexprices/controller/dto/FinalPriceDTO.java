package com.jimontoyag.capitole.inditexprices.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.Instant;

public record FinalPriceDTO(
    @JsonProperty("product_id") long productId,
    @JsonProperty("brand_id") long brandId,
    @JsonProperty("price_id") long priceId,
    @JsonProperty("from_date") Instant fromDate,
    @JsonProperty("to_date") Instant toDate,
    BigDecimal price,
    String currency) {}
