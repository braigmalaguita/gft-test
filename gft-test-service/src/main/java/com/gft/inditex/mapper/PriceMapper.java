package com.gft.inditex.mapper;

import com.gft.inditex.entity.PriceEntity;
import com.gtf.inditex.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toPrice(PriceEntity priceEntity);

    PriceEntity toPriceEntity(Price price);
}
