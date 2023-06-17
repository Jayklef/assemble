package com.example.assemble.serviceImpl;

import com.example.assemble.dto.SupplierDto;
import com.example.assemble.entity.Supplier;
import com.example.assemble.repository.SupplierRepository;
import com.example.assemble.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier createSupplier(SupplierDto supplierDto) {
        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        supplier.setDescription(supplierDto.getDescription());
        supplier.setAddress(supplierDto.getAddress());
        supplier.setEmail(supplierDto.getEmail());

        return supplierRepository.save(supplier);
    }

    @Override
    public List<Supplier> getSuppliers() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findSupplier(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        if (!supplier.isPresent()){
            throw new RuntimeException("Supplier with the Id of " + id + "not found");
        }
        return supplier.get();
    }
}
