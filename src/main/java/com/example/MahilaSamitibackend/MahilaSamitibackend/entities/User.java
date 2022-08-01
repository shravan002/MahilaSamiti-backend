package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String name;
    private String role;

    @ManyToOne
    @JsonBackReference
    private Committee committeeMember;

    @Enumerated(EnumType.STRING)
    private Gender gender;

//    @OneToOne(mappedBy = "admin")
//    @JsonBackReference
//    private Committee committee;

}
