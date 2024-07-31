package com.gtf.inditex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    private Integer id;
    private Product product;
    private Brand brand;
    private Double price;
    private Date startDate;
    private Date endDate;
    private PriceList priceList;
    private Integer priority;
    private String curr;
}
