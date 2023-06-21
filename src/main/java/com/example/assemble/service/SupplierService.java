package com.example.assemble.service;

import com.example.assemble.dto.SupplierDto;
import com.example.assemble.entity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier createSupplier(SupplierDto supplierDto);

    List<Supplier> getSuppliers();

    Supplier findSupplier(Long id);

    Supplier updateSupplier(Long id, SupplierDto supplierDto);

    void deleteSupplier(Long id);
}
