package com.adso.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adso.api.models.Tema;
import com.adso.api.repository.TemasRepository;


/*
* Never EVER FORGET TU PUT @SERVICE because then the app will not recognize this service and throw problems back at you
*/
@Service
public class TemaServices {
    private TemasRepository temasRepository;

    public TemaServices(TemasRepository temasRepository) {
        this.temasRepository = temasRepository;
    }

    public List<Tema> findAllTemas(){
        return temasRepository.findAll();
    }

    public Tema findTemaById(Integer id){
        return temasRepository.findById(id).orElse(null);
    }

    public Tema createTema ( String tema){
        return temasRepository.saveTema( tema);
    }

    public void deleteTema(Integer id){
        temasRepository.deleteById(id);
    }
}
