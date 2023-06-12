package com.example.assemble.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private String name;
    private LocalDate transactionDate;
    private String description;
    private Double amount;
}
