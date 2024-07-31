package com.gft.inditex.mapper;

import com.gft.inditex.api.model.BrandDto;
import com.gft.inditex.api.model.PriceDto;
import com.gft.inditex.api.model.PriceListDto;
import com.gft.inditex.api.model.ProductDto;
import com.gtf.inditex.model.Brand;
import com.gtf.inditex.model.Price;
import com.gtf.inditex.model.PriceList;
import com.gtf.inditex.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapperDto {

    Price toPrice(PriceDto priceDto);
    PriceDto toPriceDto(Price price);

    Product toProduct(ProductDto productDto);

    ProductDto toProductDto(Product product);

    Brand toBrand(BrandDto brandDto);

    BrandDto toBrandDto(Brand brand);

    PriceListDto toPriceListDto(PriceList priceList);

    PriceList toPriceList(PriceListDto priceListDto);

}
