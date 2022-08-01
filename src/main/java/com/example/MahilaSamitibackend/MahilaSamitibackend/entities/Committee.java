package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String committeeName;

    @OneToMany(mappedBy = "committeeMember", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<User> memberList = new ArrayList<>();

    @Column(length = 500)
    private String description;
}
