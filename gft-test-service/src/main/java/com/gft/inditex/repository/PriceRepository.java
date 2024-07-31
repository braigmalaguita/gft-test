package com.gft.inditex.repository;

import com.gft.inditex.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer> {

    List<PriceEntity> findByBrand_IdAndProduct_Id(Integer brand, Integer product);
}
