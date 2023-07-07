package com.example.assemble.serviceImpl;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;
import com.example.assemble.exception.ResourceNotFoundException;
import com.example.assemble.repository.ProductRepository;
import com.example.assemble.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
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
            throw new ResourceNotFoundException("Product with id of" + id + " is not present");
        }
        return product.get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {

        Product productInDb = productRepository.findById(id).get();
        if (Objects.nonNull(product.getName()) &&
        !"".equalsIgnoreCase(product.getName())){
            productInDb.setName(product.getName());
        }

        if (Objects.nonNull(product.getIsPerishable()) &&
        !"".equalsIgnoreCase(product.getIsPerishable().toString())){
            productInDb.setIsPerishable(product.getIsPerishable());
        }

        if (Objects.nonNull(product.getSupplyDate())){
            productInDb.setSupplyDate(new Date());
        }

        if (Objects.nonNull(product.getQuantity()) &&
        !"".equalsIgnoreCase(product.getQuantity().toString())){
            productInDb.setQuantity(product.getQuantity());
        }

        if (Objects.nonNull(product.getUnitPrice()) &&
        !"".equalsIgnoreCase(product.getUnitPrice().toString())){
            productInDb.setUnitPrice(product.getUnitPrice());
        }

        return productRepository.save(productInDb);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public Page<Product> findProductPagination(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable);
    }


}
