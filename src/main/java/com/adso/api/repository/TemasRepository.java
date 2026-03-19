package com.adso.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adso.api.models.Tema;

import jakarta.transaction.Transactional;

public interface TemasRepository extends JpaRepository<Tema, Integer> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tema (tema) VALUES (:tema)", nativeQuery = true)
    Tema saveTema(@Param("tema") String tema);

}
