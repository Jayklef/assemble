package com.example.assemble.service;

import com.example.assemble.dto.SupplierDto;
import com.example.assemble.entity.Supplier;

public interface SupplierService {
    Supplier createSupplier(SupplierDto supplierDto);
}
