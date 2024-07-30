package com.gtf.inditex.model;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Price {
    private Integer id;
    private Product product;
    private Brand brand;
    private LocalDate applyDate;
    private Double price;

}
