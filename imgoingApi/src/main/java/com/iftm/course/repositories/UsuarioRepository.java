package com.iftm.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.course.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}