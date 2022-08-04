package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    List<Transaction> getTransactions(String memberId);
}
