package com.example.assemble.serviceImpl;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;
import com.example.assemble.repository.ProductRepository;
import com.example.assemble.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(ProductDto productDto) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setIsPerishable(productDto.getIsPerishable());
        product.setSupplyDate(productDto.getSupplyDate());
        product.setQuantity(product.getQuantity());
        product.setUnitPrice(productDto.getUnitPrice());
        return productRepository.save(product);
    }
}
