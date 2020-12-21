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

import com.iftm.imgoingapi.DTO.CategoriaDTO;
import com.iftm.imgoingapi.entities.Categoria;
import com.iftm.imgoingapi.repositories.CategoriaRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public List<CategoriaDTO> findAll(){
		List<Categoria> list = repository.findAll();
		return list.stream().map(e -> new CategoriaDTO(e)).collect(Collectors.toList());
	}
	
	public CategoriaDTO findbyId(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		Categoria entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CategoriaDTO(entity);
	}
	
	public CategoriaDTO insert(CategoriaDTO dto) {
		Categoria entity = dto.toEntity();
		entity = repository.save(entity);
		return new CategoriaDTO(entity);
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
	public CategoriaDTO update(Long id, CategoriaDTO dto) {
		try {
			Categoria entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new CategoriaDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Categoria entity, CategoriaDTO dto) {
		entity.setNome(dto.getNome());
		entity.setDescricao(dto.getDescricao());
		
	}
}
