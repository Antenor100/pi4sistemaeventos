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

import com.iftm.imgoingapi.DTO.IngressoDTO;
import com.iftm.imgoingapi.entities.Ingresso;
import com.iftm.imgoingapi.repositories.IngressoRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class IngressoService {

	@Autowired
	private IngressoRepository repository;
	
	public List<IngressoDTO> findAll(){
		List<Ingresso> list = repository.findAll();
		return list.stream().map(e -> new IngressoDTO(e)).collect(Collectors.toList());
	}
	
	public IngressoDTO findbyId(Long id) {
		Optional<Ingresso> obj = repository.findById(id);
		Ingresso entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new IngressoDTO(entity);
	}
	
	public IngressoDTO insert(IngressoDTO dto) {
		Ingresso entity = dto.toEntity();
		entity = repository.save(entity);
		return new IngressoDTO(entity);
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
	public IngressoDTO update(Long id, IngressoDTO dto) {
		try {
			Ingresso entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new IngressoDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Ingresso entity, IngressoDTO dto) {
		entity.setValor(dto.getValor());
		entity.setDatahorapagamento(dto.getDataPagamento());
		entity.setValorpagamento(dto.getValorPagamento());
		entity.setDatahoraaquisicao(dto.getDataAquisicao());
		entity.setFormapagamento(dto.getFormaPagamento());
		entity.setUsuario(dto.getUsuario());
		entity.setEvento(dto.getEvento());
	}
}
