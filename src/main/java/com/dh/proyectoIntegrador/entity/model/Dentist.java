package com.dh.proyectoIntegrador.entity.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "dentist")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "lic")
    private long licence;

    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private List<Turn> turns;

    public Dentist(String name, String surname, long licence) {
        this.name = name;
        this.surname = surname;
        this.licence = licence;
    }
}
