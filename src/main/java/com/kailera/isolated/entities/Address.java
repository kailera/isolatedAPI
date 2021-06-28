package com.kailera.isolated.entities;

import com.kailera.isolated.enuns.AddressType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column
    private AddressType addressType;

    @Column(nullable = false)
    private String publicPlace;

    @Column(nullable = false)
    private Integer numberAddress;

    @Column
    private String district;

}
