package com.dh.proyectoIntegrador.controller;

import com.dh.proyectoIntegrador.entity.dto.DentistDto;
import com.dh.proyectoIntegrador.entity.model.Dentist;
import com.dh.proyectoIntegrador.service.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dentist")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {this.dentistService = dentistService; }

    @GetMapping
    public ResponseEntity<List<Dentist>> listDentists() {
        return ResponseEntity.ok(dentistService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<Dentist> save(@RequestBody Dentist dentist) throws Exception {
        try{
            return ResponseEntity.ok(dentistService.save(dentist));
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDto> get(@PathVariable Integer id) {
        DentistDto dentistDto = dentistService.getById(id).orElse(null);
        return ResponseEntity.ok(dentistDto);
    }

    @Transactional
    @PutMapping("/update")
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentistDetail) {
        ResponseEntity<Dentist> response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if(dentistDetail != null){
            response = ResponseEntity.ok(dentistService.modify(dentistDetail));
        }
        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;
        try{
            if (id != null && dentistService.getById(id).isPresent()) {
                if(dentistService.delete(id)){
                    response = ResponseEntity.status(HttpStatus.OK).body("deleted");
                }
            }
        }catch (Exception e){
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
