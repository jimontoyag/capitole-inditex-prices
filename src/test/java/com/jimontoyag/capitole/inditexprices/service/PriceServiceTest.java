package com.jimontoyag.capitole.inditexprices.service;

import com.jimontoyag.capitole.inditexprices.entity.PriceEntity;
import com.jimontoyag.capitole.inditexprices.repository.PriceRepository;
import com.jimontoyag.capitole.inditexprices.service.impl.PriceServiceImpl;
import com.jimontoyag.capitole.inditexprices.service.mapper.PriceEntityMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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

    @Test
    void validFinalPrice() {
        Instant date = Instant.parse("2023-03-22T11:00:00Z");
        var entity = new PriceEntity();
        entity.setId(2L);
        entity.setProductId(2L);
        entity.setBrandId(2L);
        entity.setStartDate(date);
        entity.setEndDate(date);
        entity.setPrice(BigDecimal.valueOf(25.2));
        entity.setCurrency("EUR");
        when(priceRepository.findFinalPrice(2L, 2L, date)).thenReturn(Optional.of(entity));

        var result = priceService.finalPrice(date, 1L, 1L);

        assertFalse(result.isEmpty());

        var price = result.get();

        assertEquals(entity.getId(), price.id() );
        assertEquals(entity.getProductId(), price.productId() );
        assertEquals(entity.getBrandId(), price.brandId() );
        assertEquals(entity.getStartDate(), price.fromDate() );
        assertEquals(entity.getEndDate(), price.toDate() );
        assertEquals(entity.getPrice(), price.price() );
        assertEquals(entity.getCurrency(), price.currency() );
    }
}