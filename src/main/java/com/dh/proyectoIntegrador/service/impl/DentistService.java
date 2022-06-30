package com.dh.proyectoIntegrador.service.impl;

import com.dh.proyectoIntegrador.entity.dto.DentistDto;
import com.dh.proyectoIntegrador.entity.model.Dentist;
import com.dh.proyectoIntegrador.repository.DentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DentistService {
    private final DentistRepository dentistRepository;
    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }
    public Dentist save(Dentist dentist) { return dentistRepository.save(dentist); }
    public List<Dentist> getAll() { return dentistRepository.findAll(); }
    @Transactional
    public boolean delete(Integer id){
        boolean deleted = false;
        try{
            Optional<Dentist> opt = dentistRepository.findById(id);
            if(opt.isPresent()){
                dentistRepository.deleteById(id);
                deleted = true;
            }
        }catch (Exception e){
            deleted = false;
        }
        return deleted;
    }
    public Dentist modify(Dentist dentist) {
        Dentist dentistUpdated = null;
        try{
            Optional<Dentist> opt = dentistRepository.findById(dentist.getId());
            if(opt.isPresent()){
                dentistUpdated = dentistRepository.save(dentist);
            }
        }catch (Exception e){
            dentistUpdated = null;
        }
        return dentistUpdated;
    }
    public Optional<DentistDto> getById(Integer id) {
        ObjectMapper mapper = new ObjectMapper();

        Optional<Dentist> dentist = dentistRepository.findById(id);
        Optional<DentistDto> dentistDto;

        dentistDto = Optional.of(mapper.convertValue(dentist, DentistDto.class));

        return dentistDto;
    }
}
