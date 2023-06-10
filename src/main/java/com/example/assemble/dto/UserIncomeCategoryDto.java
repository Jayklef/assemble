package com.example.assemble.dto;

import com.example.assemble.entity.Transaction;
import lombok.Data;

import java.util.List;

@Data
public class UserIncomeCategoryDto {

    private Long categoryId;
    private String name;
    private List<Transaction> transactionList;
}
