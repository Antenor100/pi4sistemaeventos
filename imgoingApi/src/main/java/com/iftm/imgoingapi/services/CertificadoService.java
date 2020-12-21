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

import com.iftm.imgoingapi.DTO.CertificadoDTO;
import com.iftm.imgoingapi.entities.Certificado;
import com.iftm.imgoingapi.repositories.CertificadoRepository;
import com.iftm.imgoingapi.services.exceptions.DatabaseException;
import com.iftm.imgoingapi.services.exceptions.ResourceNotFoundException;

@Service
public class CertificadoService {

	@Autowired
	private CertificadoRepository repository;
	
	public List<CertificadoDTO> findAll(){
		List<Certificado> list = repository.findAll();
		return list.stream().map(e -> new CertificadoDTO(e)).collect(Collectors.toList());
	}
	
	public CertificadoDTO findbyId(Long id) {
		Optional<Certificado> obj = repository.findById(id);
		Certificado entity =  obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CertificadoDTO(entity);
	}
	
	public CertificadoDTO insert(CertificadoDTO dto) {
		Certificado entity = dto.toEntity();
		entity = repository.save(entity);
		return new CertificadoDTO(entity);
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
	public CertificadoDTO update(Long id, CertificadoDTO dto) {
		try {
			Certificado entity = repository.getOne(id);
			updateData(entity, dto);
			entity = repository.save(entity);
			return new CertificadoDTO(entity);
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Certificado entity, CertificadoDTO dto) {
		entity.setLink(dto.getLink());
		entity.setDataEmissao(dto.getDataEmissao());
		entity.setEvento(dto.getEvento());
		entity.setUsuario(dto.getUsuario());
	}
}
