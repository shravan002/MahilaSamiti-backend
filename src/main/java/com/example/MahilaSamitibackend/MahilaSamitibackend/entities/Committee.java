package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="committee")
public class Committee {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long CommitteeId;

    //Cascade: it will save the User entity first then committee entity
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private User admin;

    private String CommitteeName;
}
