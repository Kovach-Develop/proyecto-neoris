package com.api.proyect.nero.Repository;

import com.api.proyect.nero.Model.TelefonoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<TelefonoModel, Long> {
}
