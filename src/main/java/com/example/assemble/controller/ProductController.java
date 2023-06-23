package com.example.assemble.controller;

import com.example.assemble.dto.ProductDto;
import com.example.assemble.entity.Product;
import com.example.assemble.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@Validated ProductDto productDto){
        Product newProduct = productService.saveProduct(productDto);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts(){
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id){
        Product product = productService.getProduct(id);
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id){
       productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
                                                 @RequestBody Product product){
        Product prodToUpdate = productService.updateProduct(id, product);
        return new ResponseEntity<>(prodToUpdate, HttpStatus.OK);
    }

}
