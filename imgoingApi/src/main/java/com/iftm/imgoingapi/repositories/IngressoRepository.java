package com.iftm.imgoingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.imgoingapi.entities.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long>{

}