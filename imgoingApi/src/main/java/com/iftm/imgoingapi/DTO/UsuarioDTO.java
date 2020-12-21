package com.iftm.imgoingapi.DTO;

import java.io.Serializable;
import java.util.Date;

import com.iftm.imgoingapi.entities.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String razaoSocial;
	private String email;
	private String senha;
	private String telefone;
	private Date dataNascimento;
	private String cpf;
	private String cnpj;

	public UsuarioDTO() {
		
	}
	
	public UsuarioDTO(Long id, String nome, String razaoSocial, String email, String senha, Date dataNascimento,
			String cpf, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.cnpj = cnpj;
	}
	
	public UsuarioDTO(Usuario entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.razaoSocial = entity.getRazaoSocial();
		this.email = entity.getEmail();
		this.senha = entity.getSenha();
		this.dataNascimento = entity.getDataNascimento();
		this.cpf = entity.getCpf();
		this.cnpj = entity.getCnpj();
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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Usuario toEntity() {
		return new Usuario(id, nome, razaoSocial, email, senha, dataNascimento, cpf, cnpj);
	}		
}