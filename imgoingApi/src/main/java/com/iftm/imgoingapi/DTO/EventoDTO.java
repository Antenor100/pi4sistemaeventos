package com.iftm.imgoingapi.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.iftm.imgoingapi.entities.Categoria;
import com.iftm.imgoingapi.entities.Endereco;
import com.iftm.imgoingapi.entities.Evento;
import com.iftm.imgoingapi.entities.Usuario;

public class EventoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Não pode ser vazio!")
	@Length(min = 5, max = 100, message = "Min. 5 Max 100 caracteres")
	private String titulo;
	private String imagem;
	@NotEmpty(message = "Não pode ser vazio!")
	private Date dataHoraInicio;
	@NotEmpty(message = "Não pode ser vazio!")
	private Date dataHoraTermino;
	@NotEmpty(message = "Não pode ser vazio!")
	private String descricao;
	private Integer qtdeMaximaIngresso;
	@NotEmpty(message = "Não pode ser vazio!")
	private Categoria categoria;
	@NotEmpty(message = "Não pode ser vazio!")
	private Usuario usuario;
	@NotEmpty(message = "Não pode ser vazio!")
	private Endereco endereco;
	
	public EventoDTO() {
		
	}	

	public EventoDTO(Long id, String titulo, String imagem, Date dataHoraInicio, Date dataHoraTermino, String descricao,
			Integer qtdeMaximaIngresso, Categoria categoria, Usuario usuario, Endereco endereco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.imagem = imagem;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraTermino = dataHoraTermino;
		this.descricao = descricao;
		this.qtdeMaximaIngresso = qtdeMaximaIngresso;
		this.categoria = categoria;
		this.usuario = usuario;
		this.endereco = endereco;
	}

	public EventoDTO(Evento entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
		this.imagem = entity.getImagem();
		this.dataHoraInicio = entity.getDatahorainicio();
		this.dataHoraTermino = entity.getDatahoratermino();
		this.descricao = entity.getDescricao();
		this.qtdeMaximaIngresso = entity.getQtdmaximaingresso();
		this.categoria = entity.getCategoria();
		this.usuario = entity.getUsuario();
		this.endereco = entity.getEndereco();
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

	public Date getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(Date dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public Date getDataHoraTermino() {
		return dataHoraTermino;
	}

	public void setDataHoraTermino(Date dataHoraTermino) {
		this.dataHoraTermino = dataHoraTermino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQtdeMaximaIngresso() {
		return qtdeMaximaIngresso;
	}

	public void setQtdeMaximaIngresso(Integer qtdeMaximaIngresso) {
		this.qtdeMaximaIngresso = qtdeMaximaIngresso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public Evento toEntity() {
		return new Evento(id, titulo, imagem, dataHoraInicio, dataHoraTermino, descricao, qtdeMaximaIngresso, categoria, usuario, endereco);
	}
}