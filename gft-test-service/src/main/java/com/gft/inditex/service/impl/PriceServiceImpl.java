package com.gft.inditex.service.impl;

import com.gft.inditex.dao.PriceDao;
import com.gtf.inditex.exception.PriceNotFoundException;
import com.gtf.inditex.model.Price;
import com.gtf.inditex.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@Slf4j
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceDao dao;

    @Override
    public Price findPricesByParams(Date date, Integer productId, Integer brandId) throws PriceNotFoundException {
        List<Price> result =  dao.findByParams(productId, brandId);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date promptedDate = new Date(date.getTime());
        List<Price> filtered = dateFilter(promptedDate, result);
        filtered = priorityFilter(filtered);
        if (filtered.isEmpty()) {
            throw new PriceNotFoundException();
        }
        return filtered.get(0);
    }

    List<Price> dateFilter(Date date, List<Price> prices) {
        return prices.stream().filter(e->
                date.after(e.getStartDate()) && date.before(e.getEndDate()
                )).collect(Collectors.toList());
    }

    List<Price> priorityFilter(List<Price> prices) {
        if (prices.size() > 1) {
            prices = prices.stream()
                    .collect(groupingBy(Price::getPriority))
                    .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getKey))
                    .get()
                    .getValue();
        }
        return prices;
    }
}
