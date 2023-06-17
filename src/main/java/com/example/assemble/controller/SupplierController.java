package com.example.assemble.controller;

import com.example.assemble.dto.SupplierDto;
import com.example.assemble.entity.Supplier;
import com.example.assemble.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;
    @PostMapping("/save")
    public ResponseEntity<Supplier> createSupplier(@RequestBody SupplierDto supplierDto){
        Supplier supplier = supplierService.createSupplier(supplierDto);
        return new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }
}
