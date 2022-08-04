package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "committee")
public class Committee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "committee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Member> memberList = new ArrayList<>();

    //Values expected in terms of month
    private int life;
    //MPR: Monthly percentage rate
    private int mpr;

    @Enumerated(EnumType.STRING)
    private CollectionFrequency collectionFrequency;

    private Long totalBalance;
    private Long lentAmount;
    private Long interestBalance;

}
