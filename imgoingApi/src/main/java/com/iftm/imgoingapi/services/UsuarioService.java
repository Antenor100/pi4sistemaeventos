package com.iftm.imgoingapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.imgoingapi.DTO.UsuarioDTO;
import com.iftm.imgoingapi.entities.Usuario;
import com.iftm.imgoingapi.repositories.UsuarioRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<UsuarioDTO> findAll(){
		List<Usuario> list = repository.findAll();
		return list.stream().map(e -> new UsuarioDTO(e)).collect(Collectors.toList());
	}
	
	public UsuarioDTO findbyId(Long id) {
		Optional<Usuario> obj = repository.findById(id);
		Usuario entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new UsuarioDTO(entity);
	}
	
	public UsuarioDTO insert(UsuarioDTO dto) {
		Usuario entity = dto.toEntity();
		entity = repository.save(entity);
		return new UsuarioDTO(entity);
	}
	
	public void deleted(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage()); 
		}
	}
	
	@Transactional
	public UsuarioDTO update(Long id, UsuarioDTO dto) {
		try {
			Usuario entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new UsuarioDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Usuario entity, UsuarioDTO dto) {
	 entity.setNome(dto.getNome());
	 entity.setRazaoSocial(dto.getRazaoSocial());
	 
		entity.setEmail(dto.getEmail());
		entity.setSenha(dto.getSenha());
		entity.setTelefone(dto.getSenha());
		entity.setDataNascimento(dto.getDataNascimento());
		entity.setCpf(dto.getCpf());
		entity.setCnpj(dto.getCnpj());

		
	}
}