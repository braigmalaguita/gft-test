package com.gtf.inditex.service;

import com.gtf.inditex.exception.PriceNotFoundException;
import com.gtf.inditex.model.Price;

import java.util.Date;

public interface PriceService {

    Price findPricesByParams(Date date, Integer productId, Integer brandId) throws PriceNotFoundException;
}
