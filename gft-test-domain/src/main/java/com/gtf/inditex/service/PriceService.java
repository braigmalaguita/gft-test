package com.gtf.inditex.service;

import com.gtf.inditex.model.Price;

import java.text.ParseException;
import java.util.Date;

public interface PriceService {

    Price findPricesByParams(Date date, Integer productId, Integer brandId) throws ParseException;
}
