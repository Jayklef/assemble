package com.example.assemble.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private BigDecimal unitPrice;
    private Date supplyDate;
    private Boolean isPerishable;
    private Long quantity;
}
