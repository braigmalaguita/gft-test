package com.gft.inditex.controller;

import com.gft.inditex.api.model.PriceDto;
import com.gft.inditex.api.rest.PriceApiDelegate;
import com.gft.inditex.service.impl.PriceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
public class PriceController implements PriceApiDelegate {

    @Autowired
    PriceServiceImpl priceService;

    @Override
    public ResponseEntity<List<PriceDto>> findPricesByParams(OffsetDateTime date, Integer productId, Integer brandId) {
        //TODO service
        priceService.findPricesByParams(date, productId, brandId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
