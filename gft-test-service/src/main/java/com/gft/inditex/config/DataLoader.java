package com.gft.inditex.config;

import com.gft.inditex.entity.BrandEntity;
import com.gft.inditex.entity.PriceEntity;
import com.gft.inditex.entity.ProductEntity;
import com.gft.inditex.repository.BrandRepository;
import com.gft.inditex.repository.PriceRepository;
import com.gft.inditex.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PriceRepository priceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        // Load initial data into the database
        ProductEntity product = productRepository.save(new ProductEntity(35455, "producto"));
        BrandEntity brand = brandRepository.save( new BrandEntity(1, "zara"));
        priceRepository.save(new PriceEntity(1, product, brand , 25.50, simpleDateFormat.parse("2020-06-14 00:00:00"), simpleDateFormat.parse("2020-06-14 00:00:00"), 1,false, "EUR"));
        priceRepository.save(new PriceEntity(2, product, brand , 25.45, simpleDateFormat.parse("2020-06-14 15:00:00"), simpleDateFormat.parse("2020-06-14 18:30:00"), 1,true, "EUR"));
        priceRepository.save(new PriceEntity(3, product, brand , 30.50, simpleDateFormat.parse("2020-06-15 00:00:00"), simpleDateFormat.parse("2020-06-15 11:00:00"), 1,true, "EUR"));
        priceRepository.save(new PriceEntity(4, product, brand , 38.95, simpleDateFormat.parse("2020-06-15 16:00:00"), simpleDateFormat.parse("2020-12-31 23:59:59"), 1,true, "EUR"));
    }
}