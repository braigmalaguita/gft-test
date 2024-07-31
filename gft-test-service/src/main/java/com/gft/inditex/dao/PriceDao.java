package com.gft.inditex.dao;

import com.gft.inditex.entity.PriceEntity;
import com.gtf.inditex.exception.PriceNotFoundException;
import com.gft.inditex.mapper.PriceMapper;
import com.gft.inditex.repository.PriceRepository;
import com.gtf.inditex.model.Price;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PriceDao {

    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceMapper priceMapper;

    public List<Price> findByParams(Integer productId, Integer brandId) throws PriceNotFoundException {
        List<PriceEntity> result = priceRepository.findByBrand_IdAndProduct_Id(brandId, productId);
        if(result.isEmpty()) {
            throw new PriceNotFoundException();
        }
        return priceMapper.toPriceList(result);
    }
}
