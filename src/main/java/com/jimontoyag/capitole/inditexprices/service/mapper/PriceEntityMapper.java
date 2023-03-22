package com.jimontoyag.capitole.inditexprices.service.mapper;

import com.jimontoyag.capitole.inditexprices.entity.PriceEntity;
import com.jimontoyag.capitole.inditexprices.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PriceEntityMapper {

    @Mapping(source = "startDate", target = "fromDate")
    @Mapping(source = "endDate", target = "toDate")
    Price entityToModel(PriceEntity entity);
}
