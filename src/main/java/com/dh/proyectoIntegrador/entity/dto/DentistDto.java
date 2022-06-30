package com.dh.proyectoIntegrador.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties( ignoreUnknown = true )
@JsonPropertyOrder( alphabetic = true )
public class DentistDto {

    public Integer id;
    public String name;
    public String surname;
    private long licence;

    public DentistDto(String name, String surname, long licence) {
        this.name = name;
        this.surname = surname;
        this.licence = licence;
    }
}
