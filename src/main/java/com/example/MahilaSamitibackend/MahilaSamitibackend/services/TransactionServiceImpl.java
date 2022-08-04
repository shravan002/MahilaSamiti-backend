package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.dao.TransactionDao;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        return transactionDao.save(transaction);
    }

    @Override
    public List<Transaction> getTransactions(String memberId) {
        return transactionDao.findTransactionByMemberId(memberId);
    }
}
