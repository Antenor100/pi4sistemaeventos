package com.iftm.imgoingapi.entities;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "evento")
public class Evento  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String imagem;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date datahorainicio;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Date datahoratermino;
	
	private String descricao;
	private Integer qtdmaximaingresso;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "evento")
	private List<Certificado> certificados = new ArrayList<>();
	
	@OneToMany(mappedBy = "evento")
	private List<Ingresso> ingressos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	public Evento() {
		
	}

	public Evento(Long id, String titulo, String imagem, Date dataHoraInicio, Date dataHoraTermino, String descricao,
			Integer qtdeMaximaIngresso,Categoria categoria, Usuario usuario, Endereco endereco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.imagem = imagem;
		this.datahorainicio = dataHoraInicio;
		this.datahoratermino = dataHoraTermino;
		this.descricao = descricao;
		this.qtdmaximaingresso = qtdeMaximaIngresso;
		this.categoria = categoria;
		this.usuario = usuario;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Date getDatahorainicio() {
		return datahorainicio;
	}

	public void setDatahorainicio(Date datahorainicio) {
		this.datahorainicio = datahorainicio;
	}

	public Date getDatahoratermino() {
		return datahoratermino;
	}

	public void setDatahoratermino(Date datahoratermino) {
		this.datahoratermino = datahoratermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdmaximaingresso() {
		return qtdmaximaingresso;
	}

	public void setQtdmaximaingresso(Integer qtdmaximaingresso) {
		this.qtdmaximaingresso = qtdmaximaingresso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Certificado> getCertificados() {
		return certificados;
	}
	
	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}