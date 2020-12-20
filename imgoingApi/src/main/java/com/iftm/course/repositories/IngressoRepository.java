package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long>{

}