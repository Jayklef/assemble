package com.example.assemble.serviceImpl;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;
import com.example.assemble.repository.ProductRepository;
import com.example.assemble.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {

        Optional<Product> product = productRepository.findById(id);

        if (!product.isPresent()){
            throw new RuntimeException("Product with id of" + id + " is not present");
        }
        return product.get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }


}
