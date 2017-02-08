package com.rig.model.movel;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.rig.model.BaseModel;
import com.rig.model.Consultor;
import com.rig.model.FormaDePagamento;
import com.rig.model.Supervisor;
import com.rig.model.TipoHabilitacao;

@Entity
@Table(name = "VendaMovel")
@AttributeOverride(name = "id", column = @Column(name = "vendaMovelId"))
public class VendaMovel extends BaseModel {

	private static final long serialVersionUID = -4394384801150546380L;

	private Consultor consultor;
	private Supervisor supervisor;
	private String nomeCompleto;
	private String celular1;
	private String celular2;
	private String cpf;
	private String cidade;

	private CreditoMovel credito;
	private TipoHabilitacao tipoHabilitacao;
	private String numero;
	private PlanoVozMovel planoVozMovel;
	private PlanoMovel planoMovel;
	private PlanoDadosMovel planoDadosMovel;
	private FormaDePagamento formaDePagamento;
	private BigDecimal valor = BigDecimal.ZERO;
	private Date data;
	private Long vencimento;
	private String cheklist;
	private String vivoged;
	private String observacao;

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "consultorId")
	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "supervisorId")
	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	@NotNull
	@Column(name = "nome_completo", length = 120)
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	@NotNull
	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	@NotNull
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(length = 25)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	public CreditoMovel getCredito() {
		return credito;
	}

	public void setCredito(CreditoMovel credito) {
		this.credito = credito;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_de_habilitacao", length = 20)
	public TipoHabilitacao getTipoHabilitacao() {
		return tipoHabilitacao;
	}

	public void setTipoHabilitacao(TipoHabilitacao tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}

	@Column(length = 15)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "plano_voz_movel", length = 15)
	public PlanoVozMovel getPlanoVozMovel() {
		return planoVozMovel;
	}

	public void setPlanoVozMovel(PlanoVozMovel planoVozMovel) {
		this.planoVozMovel = planoVozMovel;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "plano_movel", length = 15)
	public PlanoMovel getPlanoMovel() {
		return planoMovel;
	}

	public void setPlanoMovel(PlanoMovel planoMovel) {
		this.planoMovel = planoMovel;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "plano_dados_movel", length = 15)
	public PlanoDadosMovel getPlanoDadosMovel() {
		return planoDadosMovel;
	}

	public void setPlanoDadosMovel(PlanoDadosMovel planoDadosMovel) {
		this.planoDadosMovel = planoDadosMovel;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_de_pagamento", length = 15)
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(length = 2)
	public Long getVencimento() {
		return vencimento;
	}

	public void setVencimento(Long vencimento) {
		this.vencimento = vencimento;
	}

	@Column(length = 60)
	public String getCheklist() {
		return cheklist;
	}

	public void setCheklist(String cheklist) {
		this.cheklist = cheklist;
	}

	@Column(length = 10)
	public String getVivoged() {
		return vivoged;
	}

	public void setVivoged(String vivoged) {
		this.vivoged = vivoged;
	}

	@Column(length = 200)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
