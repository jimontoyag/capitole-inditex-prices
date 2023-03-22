package com.jimontoyag.capitole.inditexprices.controller.mapper;

import com.jimontoyag.capitole.inditexprices.controller.dto.FinalPriceDTO;
import com.jimontoyag.capitole.inditexprices.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceControllerMapper {

  @Mapping(source = "id", target = "priceId")
  FinalPriceDTO priceModelToDTO(Price price);
}
