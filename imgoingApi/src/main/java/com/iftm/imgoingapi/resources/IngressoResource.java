package com.iftm.imgoingapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

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

import com.iftm.imgoingapi.DTO.CategoriaDTO;
import com.iftm.imgoingapi.DTO.IngressoDTO;
import com.iftm.imgoingapi.services.IngressoService;

@RestController
@RequestMapping(value = "/ingressos")
public class IngressoResource {
	
	@Autowired
	private IngressoService service;
	
	@GetMapping
	public ResponseEntity<Page<IngressoDTO>> findAllPaged(
			//adiconando link do teste
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "13") Integer linesPerPage,
			//atriburo que vai ordenar.. alterar se for necessario
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			) {	
		//classe que implementa a inteface peageble
		PageRequest pageRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction),orderBy);
		Page<IngressoDTO> list = service.findAllPaged(pageRequest);
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IngressoDTO> findById(@PathVariable Long id){
		IngressoDTO dto = service.findbyId(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<IngressoDTO> insert(@Valid @RequestBody IngressoDTO dto){
		IngressoDTO newDto = service.insert(dto);
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
	public ResponseEntity<IngressoDTO> update(@PathVariable Long id, @RequestBody IngressoDTO dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
}