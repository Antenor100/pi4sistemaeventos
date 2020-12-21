package com.iftm.imgoingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.imgoingapi.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long>{

}