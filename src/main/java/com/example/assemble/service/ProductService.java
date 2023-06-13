package com.example.assemble.service;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;

public interface ProductService {
    Product saveProduct(ProductDto productDto);
}
