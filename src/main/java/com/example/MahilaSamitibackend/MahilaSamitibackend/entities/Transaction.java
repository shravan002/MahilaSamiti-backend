package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private Long amount;
    private String user;
}
