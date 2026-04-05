package com.adso.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.api.models.Preferencia;
import com.adso.api.services.PreferenciaService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/preferencias")
public class PreferenciaController {

    private PreferenciaService preferenciaService;
    public PreferenciaController(PreferenciaService preferenciaService) {
        this.preferenciaService = preferenciaService;
    }


    @GetMapping("/getAllPreferencias")
    public List<Preferencia> findAllPreferences(){
        return preferenciaService.findAllpreferencias();
    }
    
   @GetMapping("/aprendiz/{id}")
    public List<Preferencia> buscarPorIdDeAprendiz(@PathVariable Integer id ){
        return preferenciaService.buscarPorIdDeAprendiz(id);
    }
    
    @PostMapping
    public ResponseEntity<String> crearPreferencia(@RequestParam Integer Aprendiz_id, @RequestParam Integer Tema_id) {
        Preferencia p = preferenciaService.createPreferencia(Aprendiz_id, Tema_id);
        if (p == null) {
            return ResponseEntity.badRequest().body("Aprendiz o Tema no encontrado");
        }
        return ResponseEntity.ok("Preferencia creada correctamente");
    }

}
