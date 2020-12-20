package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}