package com.iftm.imgoingapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String razaosocial;
	private String email;
	private String senha;
	private String telefone;
	private Date datanascimento;
	private String cpf;
	private String cnpj;
		
	@OneToMany(mappedBy = "usuario")
	private List<Certificado> certificados = new ArrayList<>();

	@OneToMany(mappedBy = "usuario")
	private List<Evento> eventos = new ArrayList<>();

	@OneToMany(mappedBy = "usuario",cascade={CascadeType.ALL})
	private List<Ingresso> ingressos;
	
	public Usuario() {
		
	}

	public Usuario(Long id, String nome, String razaoSocial, String email, String senha, String telefone, Date datanascimento,
			String cpf, String cnpj) {
		super();
		this.id = id;
		this.nome = nome;
		this.razaosocial = razaoSocial;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.datanascimento = datanascimento;
		this.cpf = cpf;
		this.cnpj = cnpj;
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

	public String getRazaosocial() {
		return razaosocial;
	}

	public void setRazaosocial(String razaosocial) {
		this.razaosocial = razaosocial;
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
		return datanascimento;
	}

	public void setDataNascimento(Date datanascimento) {
		this.datanascimento = datanascimento;
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
	
	public List<Certificado> getCertificados() {
		return certificados;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
