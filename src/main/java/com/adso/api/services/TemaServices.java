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
        Tema nuevoTema = new Tema();
        nuevoTema.setTema(tema);
        return temasRepository.save(nuevoTema);
    }

    public int deleteTema(Integer id){
        if (temasRepository.existsById(id)){
            temasRepository.deleteById(id);
            return 1;
        }
        return 0;
    }

    /*
     * If you want to do an update using the repository model you can use the CRUD coding
     * applying findById to find the element you want and the save() function you would 
     * normally use for the create element on the CRUD to update the element on the database
     */
    public Tema updateTema(Integer id, String tema) {
        Tema temaExistente = temasRepository.findById(id).orElse(null);
        
        if (temaExistente == null) {
            return null;
        }
        temaExistente.setTema(tema);
        return temasRepository.save(temaExistente); // save() actualiza si ya existe
    }
}
