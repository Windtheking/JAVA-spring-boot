package com.adso.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adso.api.models.Aprendiz;

import com.adso.api.repository.AprendicesRepository;

@Service
public class AprendicesServices {
    private AprendicesRepository aprendicesRepository;
    public AprendicesServices(AprendicesRepository aprendicesRepository) {
        this.aprendicesRepository = aprendicesRepository;
    }

    public List<Aprendiz> findAll(){
        return aprendicesRepository.findAll();
    }


    public List<Aprendiz> buscarPorIdDeAprendiz(Integer idAprendiz){
        return aprendicesRepository.buscarPorIdDeAprendiz(idAprendiz);
    }

        // 🔹 CREATE
    public void crearAprendiz(String nombre, String correo, Integer edad){
        aprendicesRepository.crearAprendiz(nombre, correo, edad);
    }

    // 🔹 UPDATE
    public int actualizarAprendiz(Integer id, String nombre, String correo, Integer edad){
        return aprendicesRepository.actualizarAprendiz(id, nombre, correo, edad);
    }

    // 🔹 DELETE
    public int eliminarAprendiz(Integer id){
        return aprendicesRepository.eliminarAprendiz(id);
    }
}
