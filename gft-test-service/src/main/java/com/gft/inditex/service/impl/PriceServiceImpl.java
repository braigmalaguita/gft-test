package com.gft.inditex.service.impl;

import com.gft.inditex.dao.PriceDao;
import com.gtf.inditex.model.Price;
import com.gtf.inditex.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceDao dao;

    @Override
    public List<Price> findPricesByParams(OffsetDateTime date, Integer productId, Integer brandId) {
        //TODO intervalo fechasm prioridad
        List<Price> result =  dao.findByParams(productId, brandId);
        log.info(result.toString());
        return result;

    }
}
