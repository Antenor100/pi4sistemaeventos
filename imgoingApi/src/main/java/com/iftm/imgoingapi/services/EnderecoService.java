package com.iftm.imgoingapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.imgoingapi.DTO.CategoriaDTO;
import com.iftm.imgoingapi.DTO.EnderecoDTO;
import com.iftm.imgoingapi.entities.Categoria;
import com.iftm.imgoingapi.entities.Endereco;
import com.iftm.imgoingapi.repositories.EnderecoRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repository;
	
	public Page<EnderecoDTO> findAllPaged(Pageable pageable) {
		Page<Endereco> list =  repository.findAll(pageable);
		return list.map(e -> new EnderecoDTO(e));
	}
	
	
	public EnderecoDTO findbyId(Long id) {
		Optional<Endereco> obj = repository.findById(id);
		Endereco entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new EnderecoDTO(entity);
	}
	
	public EnderecoDTO insert(EnderecoDTO dto) {
		Endereco entity = dto.toEntity();
		entity = repository.save(entity);
		return new EnderecoDTO(entity);
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
	public EnderecoDTO update(Long id, EnderecoDTO dto) {
		try {
			Endereco entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new EnderecoDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Endereco entity, EnderecoDTO dto) {

		entity.setCep(dto.getCep());
		entity.setRua(dto.getRua());
		entity.setNumero(dto.getNumero());
		entity.setBairro(dto.getBairro());
		entity.setComplemento(dto.getComplemento());
		entity.setCidade(dto.getCidade());
		entity.setEstado(dto.getEstado());
		entity.setLink(dto.getLink());
		entity.setPlataforma(dto.getPlataforma());
		
	}
}
