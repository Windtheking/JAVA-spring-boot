package com.adso.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.adso.api.models.Tema;

public interface TemasRepository extends JpaRepository<Tema, Integer> {

}
