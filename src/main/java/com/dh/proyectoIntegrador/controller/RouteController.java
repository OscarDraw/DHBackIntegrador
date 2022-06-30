package com.dh.proyectoIntegrador.controller;

import com.dh.proyectoIntegrador.entity.dto.DentistDto;
import com.dh.proyectoIntegrador.entity.model.Dentist;
import com.dh.proyectoIntegrador.service.impl.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RouteController {
    @Autowired
    private DentistService dentistService;

    @GetMapping()
    public String indexRender(Model model){
        return "index";
    }

    @GetMapping("/all-dentist")
    public ModelAndView dentistRender(Model model) {
        ModelAndView mav = new ModelAndView("views/dentist/dentist");
        mav.addObject("dentist", dentistService.getAll());
        return mav;
    }

    @GetMapping("/new-dentist")
    public ModelAndView newDentistRender() {
        ModelAndView mav = new ModelAndView("views/dentist/new");
        Dentist dentist = new Dentist();
        mav.addObject("dentist", dentist);
        return mav;
    }

    /*
     @GetMapping("/update-dentist/{dentistId}")
    public ModelAndView updateDentistRender(@PathVariable Integer dentistId) throws Exception {
        ModelAndView mav = new ModelAndView("views/dentist/update");
        DentistDto dentist = this.dentistService.getById(dentistId).get();
        mav.addObject("dentist", dentist);

        return mav;
    }
    * */
}
