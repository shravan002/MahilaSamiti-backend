package com.example.MahilaSamitibackend.MahilaSamitibackend.dao;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDao extends JpaRepository<Transaction, Long> {
    //todo findTransactionByUser -> findTransactionByUserId
    List<Transaction> findTransactionByUser(String userId);
}
