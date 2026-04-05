package com.adso.api.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.adso.api.models.Aprendiz;
import com.adso.api.repository.AprendicesRepository;

@Service
public class AprendicesServices {
    private AprendicesRepository aprendicesRepository;
    private PreferenciaService preferenciaService;

    public AprendicesServices(AprendicesRepository aprendicesRepository, PreferenciaService preferenciaService) {
        this.aprendicesRepository = aprendicesRepository;
        this.preferenciaService = preferenciaService;
    }

    public List<Aprendiz> findAll(){
        return aprendicesRepository.findAll();
    }


    public Aprendiz buscarPorIdDeAprendiz(Integer idAprendiz){
        return aprendicesRepository.findById(idAprendiz).orElse(null);
    }


 
    public Aprendiz crearAprendiz(String nombre, String correo, Integer edad, Integer temaId){
        Aprendiz a = new Aprendiz();
        a = aprendicesRepository.save(a);
        if (temaId != null) {
            preferenciaService.createPreferencia(a.getId(), temaId);
        }
        return a;
    }


    public int actualizarAprendiz(Integer id, String nombre, String correo, Integer edad){
        return aprendicesRepository.actualizarAprendiz(id, nombre, correo, edad);
    }

    public int eliminarAprendiz(Integer id){
        return aprendicesRepository.eliminarAprendiz(id);
    }
}
