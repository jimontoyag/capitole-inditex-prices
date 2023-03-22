package com.jimontoyag.capitole.inditexprices.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;

public class PriceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private Long brandId;

    private Instant startDate;




}
