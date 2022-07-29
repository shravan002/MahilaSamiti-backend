package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import lombok.*;

import javax.persistence.*;


@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private long mobileNumber;

    @Column
    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
