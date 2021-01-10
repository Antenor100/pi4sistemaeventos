package com.iftm.imgoingapi.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iftm.imgoingapi.DTO.EventoDTO;
import com.iftm.imgoingapi.entities.Evento;
import com.iftm.imgoingapi.repositories.EventoRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository repository;
	
	public Page<EventoDTO> findAllPaged(Pageable pageable) {
		Page<Evento> list =  repository.findAll(pageable);
		return list.map(e -> new EventoDTO(e));
	}
	
	public EventoDTO findbyId(Long id) {
		Optional<Evento> obj = repository.findById(id);
		Evento entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new EventoDTO(entity);
	}
	
	public EventoDTO insert(EventoDTO dto) {
		Evento entity = dto.toEntity();
		entity = repository.save(entity);
		return new EventoDTO(entity);
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
	public EventoDTO update(Long id, EventoDTO dto) {
		try {
			Evento entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new EventoDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Evento entity, EventoDTO dto) {
		entity.setTitulo(dto.getTitulo());
		entity.setImagem(dto.getImagem());
		entity.setDatahorainicio(dto.getDataHoraInicio());
		entity.setDatahoratermino(dto.getDataHoraTermino());
		entity.setDescricao(dto.getDescricao());
		entity.setQtdmaximaingresso(dto.getQtdeMaximaIngresso());
		entity.setCategoria(dto.getCategoria());
		entity.setUsuario(dto.getUsuario());
		entity.setEndereco(dto.getEndereco());	
	}
}