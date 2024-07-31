package com.gft.inditex.mapper;

import com.gft.inditex.entity.BrandEntity;
import com.gft.inditex.entity.PriceEntity;
import com.gft.inditex.entity.PriceListEntity;
import com.gft.inditex.entity.ProductEntity;
import com.gtf.inditex.model.Brand;
import com.gtf.inditex.model.Price;
import com.gtf.inditex.model.PriceList;
import com.gtf.inditex.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    Price toPrice(PriceEntity priceEntity);
    PriceEntity toPriceEntity(Price price);

    List<Price> toPriceList(List<PriceEntity> priceEntity);
    List<PriceEntity> toPriceEntityList(List<Price> price);

    Product toProduct(ProductEntity productEntity);

    ProductEntity toProductEntity(Product product);

    Brand toBrand(BrandEntity brandEntity);

    BrandEntity toBrandEntity(Brand brand);

    PriceListEntity toPriceListEntity(PriceList priceList);

    PriceListEntity toPriceList(PriceListEntity priceListEntity);
}
