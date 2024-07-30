package com.gft.inditex.service.impl;

import com.gft.inditex.dao.PriceDao;
import com.gtf.inditex.model.Price;
import com.gtf.inditex.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceDao dao;

    @Override
    public List<Price> findPricesByParams(OffsetDateTime date, Integer productId, Integer brandId) {
        //TODO mock
        dao.findById();
        return null;
    }
}
