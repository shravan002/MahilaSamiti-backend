package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String mobileNumber;
    private String name;
    private String role;

    @ManyToOne
    @JsonBackReference
    private Committee committee;
}
