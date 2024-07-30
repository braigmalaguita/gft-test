package com.gft.inditex.dao;

import com.gft.inditex.entity.PriceEntity;
import com.gft.inditex.repository.PriceRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j
public class PriceDao {

    @Autowired
    PriceRepository priceRepository;

    public List<PriceEntity> findById() {
        List<PriceEntity> result = priceRepository.findAll();
        log.info(result);
        return result;
    }
}
