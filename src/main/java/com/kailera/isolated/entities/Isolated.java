package com.kailera.isolated.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Isolated {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String  firstNameIsol;

    @Column(nullable = false)
    private String lastNameIsol;

    @JoinColumn(name = "isolatedFK")
    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private Address address;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private List <Phones> phones = new ArrayList<>();

    @Column (nullable = false)
    private LocalDate initialIsolationDate;

    @Column(nullable = false)
    private LocalDate finalIsolationDate;

    @Column
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REMOVE})
    private List<DirectContacts> directContacts = new ArrayList<>();

    //@Transient
   // private Integer remainingIsolation;
}
