package com.example.MahilaSamitibackend.MahilaSamitibackend.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
@AllArgsConstructor
@Entity
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
    //cyclicAmount: Monthly amount or Weekly amount = 200
    private long cyclicAmount;
    //todo break the entity
    private long totalBalance;
    private long lentAmount;
    private long interestBalance;
    private LocalDate creationDate;

    Committee() {
        super();
        creationDate = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Committee committee = (Committee) o;
        return id != null && Objects.equals(id, committee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
