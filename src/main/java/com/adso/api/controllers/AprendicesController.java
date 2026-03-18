package com.adso.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.api.models.Aprendiz;
import com.adso.api.services.AprendicesServices;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/aprendices")
public class AprendicesController {

    private AprendicesServices aprendicesService;
    public AprendicesController(AprendicesServices aprendicesService) {
        this.aprendicesService = aprendicesService;
    }



    @GetMapping("/getAllAprendices")
    public List<Aprendiz> findAll(){
        return aprendicesService.findAll();
    }
    
   @GetMapping("/aprendiz/{id}")
    public List<Aprendiz> buscarPorIdDeAprendiz(@PathVariable Integer id ){
        return aprendicesService.buscarPorIdDeAprendiz(id);
    }

     @PostMapping
    public ResponseEntity<String> crearAprendiz(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam Integer edad
    ) {
        aprendicesService.crearAprendiz(nombre, correo, edad);
        return ResponseEntity.ok("Aprendiz creado correctamente");
    }

    // 🔹 PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAprendiz(
            @PathVariable Integer id,
            @RequestParam String nombre,
            @RequestParam Integer edad
    ) {
        int filas = aprendicesService.actualizarAprendiz(id, nombre, edad);

        if (filas == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Aprendiz actualizado correctamente");
    }

    // 🔹 DELETE - Eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAprendiz(@PathVariable Integer id) {
        int filas = aprendicesService.eliminarAprendiz(id);

        if (filas == 0) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok("Aprendiz eliminado correctamente");
    }
}
