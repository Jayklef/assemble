package com.example.assemble.serviceImpl;

import com.example.assemble.dto.TransactionDto;
import com.example.assemble.entity.Category;
import com.example.assemble.entity.Transaction;
import com.example.assemble.entity.User;
import com.example.assemble.repository.CategoryRepository;
import com.example.assemble.repository.IncomeRepository;
import com.example.assemble.repository.UserRepository;
import com.example.assemble.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Transaction> findAllIncome() {
        return incomeRepository.findAll();
    }

    @Override
    public Transaction saveIncome(TransactionDto incomeDto) {

        Transaction transaction = new Transaction();
        transaction.setName(incomeDto.getName());
        transaction.setDescription(incomeDto.getDescription());
        transaction.setAmount(incomeDto.getAmount());
        Optional<Category> category = categoryRepository.findById(incomeDto.getCategoryId());
        transaction.setCategory(category.get());
        Optional<User> user = userRepository.findById(incomeDto.getUserId());
        transaction.setUser(user.get());

        return incomeRepository.save(transaction);
    }

}
