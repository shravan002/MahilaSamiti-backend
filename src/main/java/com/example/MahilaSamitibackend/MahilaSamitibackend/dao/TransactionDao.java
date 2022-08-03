package com.example.MahilaSamitibackend.MahilaSamitibackend.dao;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionDao extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionByUser(String userId);
}
