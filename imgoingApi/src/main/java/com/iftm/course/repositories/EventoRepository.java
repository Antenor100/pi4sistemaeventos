package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}