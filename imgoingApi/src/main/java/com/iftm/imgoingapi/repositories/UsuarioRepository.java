package com.iftm.imgoingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iftm.imgoingapi.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}