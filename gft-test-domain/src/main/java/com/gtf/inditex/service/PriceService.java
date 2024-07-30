package com.gtf.inditex.service;

import com.gtf.inditex.model.Price;

import java.time.OffsetDateTime;
import java.util.List;

public interface PriceService {

    List<Price> findPricesByParams(OffsetDateTime date, Integer productId, Integer brandId);
}
