package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    Transaction addNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/transaction/user/{userId}")
    List<Transaction> getTransactionList(@PathVariable String userId) {
        return transactionService.getTransactions(userId);
    }
}
