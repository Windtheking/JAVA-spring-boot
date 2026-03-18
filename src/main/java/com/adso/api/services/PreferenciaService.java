package com.adso.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.api.models.Preferencia;
import com.adso.api.repository.PreferenciaRepository;

@SuppressWarnings("unused")
@Service
public class PreferenciaService {
    

    private PreferenciaRepository preferenciaRepository;

    public PreferenciaService(PreferenciaRepository preferenciaRepository) {
        this.preferenciaRepository = preferenciaRepository;
    }

    public List<Preferencia> findAll(){
        return preferenciaRepository.findAll();
    }


    public List<Preferencia> buscarPorIdDeAprendiz(Integer idAprendiz){
        return preferenciaRepository.buscarPorIdDeAprendiz(idAprendiz);
    }

}
