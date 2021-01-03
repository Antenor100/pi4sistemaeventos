package com.iftm.imgoingapi.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.iftm.imgoingapi.entities.enums.FormaPagamento;

@Entity
@Table(name = "ingresso")
public class Ingresso implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valor;
	private Date datahorapagamento;
	private Double valorpagamento;
	private Date datahoraaquisicao;
	private FormaPagamento formapagamento;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_evento")
	private Evento evento;
	
	public Ingresso() {
		
	}

	public Ingresso(Long id, Double valor, Date dataPagamento, Double valorPagamento, Date dataAquisicao,
			FormaPagamento formaPagamento, Usuario usuario, Evento evento) {
		super();
		this.id = id;
		this.valor = valor;
		this.datahorapagamento = dataPagamento;
		this.valorpagamento = valorPagamento;
		this.datahoraaquisicao = dataAquisicao;
		this.formapagamento = formaPagamento;
		this.usuario = usuario;
		this.evento = evento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDatahorapagamento() {
		return datahorapagamento;
	}

	public void setDatahorapagamento(Date datahorapagamento) {
		this.datahorapagamento = datahorapagamento;
	}

	public Double getValorpagamento() {
		return valorpagamento;
	}

	public void setValorpagamento(Double valorpagamento) {
		this.valorpagamento = valorpagamento;
	}

	public Date getDatahoraaquisicao() {
		return datahoraaquisicao;
	}

	public void setDatahoraaquisicao(Date datahoraaquisicao) {
		this.datahoraaquisicao = datahoraaquisicao;
	}

	public FormaPagamento getFormapagamento() {
		return formapagamento;
	}

	public void setFormapagamento(FormaPagamento formapagamento) {
		this.formapagamento = formapagamento;
	}	
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
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
		Ingresso other = (Ingresso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}