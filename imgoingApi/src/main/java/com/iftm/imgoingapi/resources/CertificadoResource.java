package com.iftm.imgoingapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iftm.imgoingapi.DTO.CertificadoDTO;
import com.iftm.imgoingapi.services.CertificadoService;

@RestController
@RequestMapping(value = "/certificados")
public class CertificadoResource {
	
	@Autowired
	private CertificadoService service;
	
	@GetMapping
	public ResponseEntity<Page<CertificadoDTO>> findAllPaged(
			//adiconando link do teste
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "13") Integer linesPerPage,
			//atriburo que vai ordenar.. alterar se for necessario
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			) {	
		//classe que implementa a inteface peageble
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<CertificadoDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CertificadoDTO> findById(@PathVariable Long id){
		CertificadoDTO dto = service.findbyId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<CertificadoDTO> insert(@RequestBody CertificadoDTO dto){
		CertificadoDTO newDto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(newDto);
		}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.deleted(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<CertificadoDTO> update(@PathVariable Long id, @RequestBody CertificadoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}