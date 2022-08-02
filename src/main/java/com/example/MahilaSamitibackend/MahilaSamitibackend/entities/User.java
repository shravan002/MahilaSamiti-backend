package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
