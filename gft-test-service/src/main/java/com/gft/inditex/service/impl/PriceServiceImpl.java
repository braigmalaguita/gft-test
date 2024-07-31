package com.gft.inditex.service.impl;

import com.gft.inditex.dao.PriceDao;
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
    public Price findPricesByParams(Date date, Integer productId, Integer brandId) {
        List<Price> result =  dao.findByParams(productId, brandId);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        //TODO deprecado
        Date promptedDate = new Date(String.valueOf(date));
        List<Price> filtered = dateFilter(promptedDate, result);
        log.info(filtered.toString());
        filtered = priorityFilter(filtered);
        log.info(filtered.toString());
        return Objects.nonNull(filtered) && filtered.isEmpty() ? filtered.get(0) : null;
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
