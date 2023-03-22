package com.jimontoyag.capitole.inditexprices.model;

import java.math.BigDecimal;
import java.time.Instant;

public record Price(long id, long productId, long brandId, Instant fromDate, Instant toDate , BigDecimal price, String currency) {
}
