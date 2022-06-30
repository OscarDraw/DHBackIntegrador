package com.dh.proyectoIntegrador.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String street;
    private String number;
    private String location;
    private String province;

    @OneToOne(mappedBy = "address")
    private Patient patient;

    public Address(String street, String number, String location, String province) {
        this.street = street;
        this.number = number;
        this.location = location;
        this.province = province;
    }
}
