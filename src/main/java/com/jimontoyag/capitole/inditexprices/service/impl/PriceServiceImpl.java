package com.jimontoyag.capitole.inditexprices.service.impl;

import com.jimontoyag.capitole.inditexprices.model.Price;
import com.jimontoyag.capitole.inditexprices.repository.PriceRepository;
import com.jimontoyag.capitole.inditexprices.service.PriceService;
import com.jimontoyag.capitole.inditexprices.service.mapper.PriceEntityMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceEntityMapper mapper;
    public PriceServiceImpl(PriceRepository priceRepository, PriceEntityMapper mapper) {
        this.priceRepository = priceRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Price> finalPrice(Instant date, long productId, long brandId) {
        return priceRepository.findFinalPrice(productId, brandId, date)
                .map(mapper::entityToModel);
    }
}
