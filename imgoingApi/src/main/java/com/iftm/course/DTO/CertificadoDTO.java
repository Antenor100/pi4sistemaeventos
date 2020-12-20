package com.iftm.course.DTO;

import java.io.Serializable;
import java.util.Date;

import com.iftm.course.entities.Certificado;
import com.iftm.course.entities.Evento;
import com.iftm.course.entities.Usuario;

public class CertificadoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String link;
	private Date dataEmissao;
	private Evento evento;
	private Usuario usuario;
	

	public CertificadoDTO() {
		
	}
	
	public CertificadoDTO(Long id, String link, Date dataEmissao, Evento evento, Usuario usuario) {
		super();
		this.id = id;
		this.link = link;
		this.dataEmissao = dataEmissao;
		this.evento = evento;
		this.usuario = usuario;
	}

	public CertificadoDTO(Certificado entity) {
		this.id = entity.getId();
		this.link = entity.getLink();
		this.dataEmissao = entity.getDataEmissao();
		this.evento = entity.getEvento();
		this.usuario = entity.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Certificado toEntity() {
		return new Certificado(id, link, dataEmissao, this.evento, this.usuario);
	}	
}