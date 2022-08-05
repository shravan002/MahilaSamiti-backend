package com.example.MahilaSamitibackend.MahilaSamitibackend.services;

import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Committee;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Member;
import com.example.MahilaSamitibackend.MahilaSamitibackend.entities.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction addTransaction(Transaction transaction);

    List<Transaction> getTransactions(String memberId);


    //todo return type?
    Member sanctionLoan(long amount,Member member, Committee committee);

    Member minimumDuePayment(long amount, Member member, Committee committee);

    Member outstandingAmountPayment(long amount, Member member, Committee committee);

    Member cyclicPayment(long amount, Member member, Committee committee);
}
