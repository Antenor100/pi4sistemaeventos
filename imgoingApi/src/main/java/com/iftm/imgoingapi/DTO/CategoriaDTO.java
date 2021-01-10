package com.iftm.imgoingapi.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.iftm.imgoingapi.entities.Categoria;

public class CategoriaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "Não pode ser vazio!")
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {
		
	}
	

	public CategoriaDTO(Long id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}


	public CategoriaDTO(Categoria entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.descricao = entity.getDescricao();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Categoria toEntity() {
		return new Categoria(id, nome, descricao);
	}	
}