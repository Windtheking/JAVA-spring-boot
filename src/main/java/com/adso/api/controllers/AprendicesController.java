package com.adso.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adso.api.models.Aprendiz;
import com.adso.api.services.AprendicesServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/aprendices")
@Tag(name = "aprendices", description = "CRUD protocol for aprendices, for use please review first the TEMAS endpoints and content")
public class AprendicesController {

    private AprendicesServices aprendicesService;
    public AprendicesController(AprendicesServices aprendicesService) {
        this.aprendicesService = aprendicesService;
    }



    @GetMapping("/getAllAprendices")
    @Operation(
        summary = "Allows to obtain all data from the aprendices tables"
        )
    @ApiResponse(responseCode = "200", description = "Aprendiz creado exitosamente")
    public List<Aprendiz> findAll(){
        return aprendicesService.findAll();
    }
    
   @GetMapping("/aprendiz/{id}")
    public Aprendiz buscarPorIdDeAprendiz(@PathVariable Integer id ){
        return aprendicesService.buscarPorIdDeAprendiz(id);
    }

    @PostMapping
    public ResponseEntity<String> crearAprendiz(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam Integer edad,
            @RequestParam Integer temaId
    ) {
        aprendicesService.crearAprendiz(nombre, correo, edad, temaId);
        return ResponseEntity.ok("Aprendiz creado correctamente");
    }

    // 🔹 PUT - Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarAprendiz(
            @PathVariable Integer id,
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam Integer edad
    ) {
        int filas = aprendicesService.actualizarAprendiz(id, nombre, correo, edad);

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
