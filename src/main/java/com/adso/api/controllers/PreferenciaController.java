package com.adso.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adso.api.models.Preferencia;
import com.adso.api.services.PreferenciaService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/preferencias")
public class PreferenciaController {

    private PreferenciaService preferenciaService;
    public PreferenciaController(PreferenciaService preferenciaService) {
        this.preferenciaService = preferenciaService;
    }



    @GetMapping("/")
    public List<Preferencia> findAll(){
        return preferenciaService.findAll();
    }
    
   @GetMapping("/aprendiz/{id}")
    public List<Preferencia> buscarPorIdDeAprendiz(@PathVariable Integer id ){
        return preferenciaService.buscarPorIdDeAprendiz(id);
    }
    

}
