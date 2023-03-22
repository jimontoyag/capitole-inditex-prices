package com.jimontoyag.capitole.inditexprices.service;

import com.jimontoyag.capitole.inditexprices.entity.PriceEntity;
import com.jimontoyag.capitole.inditexprices.repository.PriceRepository;
import com.jimontoyag.capitole.inditexprices.service.mapper.PriceEntityMapper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PriceServiceTest {

    private PriceService priceService;

    private PriceRepository priceRepository;

    private PriceEntityMapper mapper;

    @BeforeAll
    void setUp() {
        priceRepository = mock(PriceRepository.class);
        mapper = Mappers.getMapper( PriceEntityMapper.class );
        priceService = new PriceServiceImpl(priceRepository, mapper);
    }
    @Test
    void emptyFinalPrice() {
        Instant date = Instant.parse("2023-03-22T10:00:00Z");
        when(priceRepository.findFinalPrice(1L, 1L, date)).thenReturn(Optional.empty());

        var result = priceService.finalPrice(date, 1L, 1L);

        assertTrue(result.isEmpty());
    }
}