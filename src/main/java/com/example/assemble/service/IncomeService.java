package com.example.assemble.service;

import com.example.assemble.dto.TransactionDto;
import com.example.assemble.entity.Transaction;

import java.util.List;

public interface IncomeService {
    List<Transaction> findAllIncome();

    Transaction saveIncome(TransactionDto incomeDto);

}
