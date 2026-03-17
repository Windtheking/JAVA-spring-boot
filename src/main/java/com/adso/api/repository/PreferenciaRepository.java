package com.adso.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adso.api.models.Preferencia;

public interface PreferenciaRepository extends JpaRepository<Preferencia,Integer> {
    
  @Query("SELECT p FROM Preferencia p WHERE p.aprendiz.id = :idAprendiz")
  List<Preferencia> buscarPorIdDeAprendiz(@Param("idAprendiz") Integer idAprendiz);

}
