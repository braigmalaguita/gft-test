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

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    PriceRepository priceRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    BrandRepository brandRepository;

    public DataLoader(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        ProductEntity product = productRepository.save(new ProductEntity(1, "name"));
        BrandEntity brand = brandRepository.save( new BrandEntity(1, "name"));
        priceRepository.save(new PriceEntity(1, product,brand , 1.0));
    }
}