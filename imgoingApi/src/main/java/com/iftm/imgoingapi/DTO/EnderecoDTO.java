package com.iftm.imgoingapi.DTO;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.iftm.imgoingapi.entities.Endereco;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@Length(min = 8, max = 8, message = "O campo deve ter 8 digitos!")
	private String cep;
	private String rua;
	private Integer numero;
	private String bairro;
	private String complemento;
	private String cidade; 
	private String estado;
	private String link;
	private String plataforma;
	
	public EnderecoDTO() {
		
	}
	
	public EnderecoDTO(Long id, String cep, String rua, Integer numero, String bairro, String complemento,
			String cidade, String estado, String link, String plataforma) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.link = link;
		this.plataforma = plataforma;
	}

	public EnderecoDTO(Endereco entity) {
		this.id = entity.getId();
		this.cep = entity.getCep();
		this.rua = entity.getRua();
		this.numero = entity.getNumero();
		this.bairro = entity.getBairro();
		this.complemento = entity.getComplemento();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
		this.link = entity.getLink();
		this.plataforma = entity.getPlataforma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public Endereco toEntity() {
		return new Endereco(id, cep, rua, numero, bairro, complemento, cidade, estado, link, plataforma);
	}	
}