package com.dh.proyectoIntegrador.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String surname;
    private Long DNI;
    private Date dateIn;
    private Date dateOut;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Turn> turnos;

    public Patient(String name, String surname, Address address, Long DNI, Date dateIn, Date dateOut) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.DNI = DNI;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }
}
