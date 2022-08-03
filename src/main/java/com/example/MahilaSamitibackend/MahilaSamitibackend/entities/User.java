package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
//todo Refactor from User to member
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    private String mobileNumber;
    private String name;
    private String role;

    @ManyToOne
    @JsonBackReference
    private Committee committee;
}
