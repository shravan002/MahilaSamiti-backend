package com.example.MahilaSamitibackend.MahilaSamitibackend.controllers;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import com.example.MahilaSamitibackend.MahilaSamitibackend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping
    Transaction addNewTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/member/{memberId}")
    List<Transaction> getTransactionList(@PathVariable String memberId) {
        return transactionService.getTransactions(memberId);
    }
}
