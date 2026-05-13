package com.bank.cbs.controller;

import com.bank.cbs.dto.TransactionRequestDTO;
import com.bank.cbs.entity.Transaction;
import com.bank.cbs.repository.TransactionRepository;
import com.bank.cbs.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @Autowired
    private TransactionRepository repository;

    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody TransactionRequestDTO dto) {
        return service.deposit(dto);
    }

    @GetMapping("/account/{accountId}")
    public List<Transaction> getTransactions(@PathVariable Long accountId) {
        return repository.findByAccountAccountId(accountId);
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestBody TransactionRequestDTO dto)
    {
        return service.withdraw(dto);
    }

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransactionRequestDTO dto)
    {
        return service.transfer(dto);
    }
}