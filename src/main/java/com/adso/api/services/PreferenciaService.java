package com.adso.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adso.api.models.Preferencia;
import com.adso.api.repository.AprendicesRepository;
import com.adso.api.repository.PreferenciaRepository;
import com.adso.api.repository.TemasRepository;

@SuppressWarnings("unused")
@Service
public class PreferenciaService {
    

    private PreferenciaRepository preferenciaRepository;
    private AprendicesRepository aprendicesRepository;
    private TemasRepository temasRepository;


    /**
     * Never forget to initialize on your proyect what you need, on this case I needed
     * @param preferenciaRepository
     * @param aprendicesRepository
     * @param temasRepository
     * and because I did not had any of them active nor declared on this constructor I was not initializing them for ussage
     * and hence causing a "null" value to trigger, also I am using the repositories directly because then we would fall in 
     * a circular dependency hence trunking the project.
     */
    public PreferenciaService(PreferenciaRepository preferenciaRepository, AprendicesRepository aprendicesRepository, TemasRepository temasRepository ) {
        this.preferenciaRepository = preferenciaRepository;
        this.aprendicesRepository = aprendicesRepository;
        this.temasRepository = temasRepository;
    }

    public List<Preferencia> findAllpreferencias(){
        return preferenciaRepository.findAll();
    }


    public List<Preferencia> buscarPorIdDeAprendiz(Integer idAprendiz){
        return preferenciaRepository.buscarPorIdDeAprendiz(idAprendiz);
    }


    /**
     * This function recovers the Id of the corresponding preference and turns it into a nev value for its database using the
     * @param idAprendiz
     * @param idTema
     * To connect aprendiz with its favorite tema.
     * @return
     */
    public Preferencia createPreferencia(Integer idAprendiz, Integer idTema) {
        var a = aprendicesRepository.findById(idAprendiz).orElse(null);
        var t = temasRepository.findById(idTema).orElse(null);
        if (a == null || t == null) return null;
        Preferencia p = new Preferencia();
        p.setAprendiz(a);
        p.setTema(t);
        return preferenciaRepository.save(p);
    }

}
