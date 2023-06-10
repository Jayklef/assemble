package com.example.assemble.repository;

import com.example.assemble.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeRepository extends JpaRepository<Transaction, Long> {

}
