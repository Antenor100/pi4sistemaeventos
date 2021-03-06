package com.iftm.imgoingapi.DTO;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.iftm.imgoingapi.entities.Evento;
import com.iftm.imgoingapi.entities.Ingresso;
import com.iftm.imgoingapi.entities.Usuario;
import com.iftm.imgoingapi.entities.enums.FormaPagamento;

public class IngressoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;

	@NotEmpty(message = "Não pode ser vazio!")
	@Positive(message = "Valor não pode ser negativo!")
	private Double valor;
	private Date dataPagamento;
	private Double valorPagamento;
	private Date dataAquisicao;
	private FormaPagamento formaPagamento;
	private Usuario usuario;
	private Evento evento;
	
	public IngressoDTO() {
		
	}
	
	public IngressoDTO(Long id, Double valor, Date dataPagamento, Double valorPagamento, Date dataAquisicao,
			FormaPagamento formaPagamento, Usuario usuario, Evento evento) {
		super();
		this.id = id;
		this.valor = valor;
		this.dataPagamento = dataPagamento;
		this.valorPagamento = valorPagamento;
		this.dataAquisicao = dataAquisicao;
		this.formaPagamento = formaPagamento;
		this.usuario = usuario;
		this.evento = evento;
	}

	public IngressoDTO(Ingresso entity) {
		this.id = entity.getId();
		this.valor = entity.getValor();
		this.dataPagamento = entity.getDatahorapagamento();
		this.valorPagamento = entity.getValorpagamento();
		this.dataAquisicao = entity.getDatahoraaquisicao();
		this.formaPagamento = entity.getFormapagamento();
		this.usuario = entity.getUsuario();
		this.evento = entity.getEvento();
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

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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

	public Ingresso toEntity() {
		return new Ingresso(id, valor, dataPagamento, valorPagamento, dataAquisicao, formaPagamento, usuario, evento);
	}
}
