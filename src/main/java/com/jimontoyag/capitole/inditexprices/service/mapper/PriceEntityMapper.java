package com.jimontoyag.capitole.inditexprices.service.mapper;

import com.jimontoyag.capitole.inditexprices.entity.PriceEntity;
import com.jimontoyag.capitole.inditexprices.model.Price;
import org.mapstruct.Mapper;

@Mapper
public interface PriceEntityMapper {

    Price entityToModel(PriceEntity entity);
}
