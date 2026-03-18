package com.adso.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.adso.api.models.Aprendiz;

import jakarta.transaction.Transactional;


public interface AprendicesRepository extends JpaRepository<Aprendiz, Integer> {
    @Query("SELECT a FROM Aprendiz a WHERE a.id = :idAprendiz")
    List<Aprendiz> buscarPorIdDeAprendiz(@Param("idAprendiz") Integer idAprendiz);

    @Modifying
    @Transactional
    @Query("UPDATE Aprendiz a SET a.nombre = :nombre, a.correo = :correo, a.edad = :edad WHERE a.id = :id")
    int actualizarAprendiz(
        @Param("id") Integer id,
        @Param("nombre") String nombre,
        @Param("correo") String correo,
        @Param("edad") Integer edad
    );

    @Modifying
    @Transactional
    @Query("DELETE FROM Aprendiz a WHERE a.id = :id")
    int eliminarAprendiz(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO public.adso_nocturno (nombre, correo, edad) VALUES (:nombre, :correo, :edad)", nativeQuery = true)
    void crearAprendiz(@Param("nombre") String nombre, @Param("correo") String correo, @Param("edad") Integer edad);

}
