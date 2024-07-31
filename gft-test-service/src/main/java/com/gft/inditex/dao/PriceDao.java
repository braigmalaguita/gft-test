package com.gft.inditex.dao;

import com.gft.inditex.entity.PriceEntity;
import com.gft.inditex.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class PriceDao {

    @Autowired
    PriceRepository priceRepository;

    public List<PriceEntity> findById() {
        List<PriceEntity> result = priceRepository.findAll();
        Optional<PriceEntity> r2 = priceRepository.findById(1);
        log.info(result.toString() + r2);
        return result;
    }
}
