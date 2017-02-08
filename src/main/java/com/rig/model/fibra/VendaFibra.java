package com.rig.model.fibra;

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

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.rig.model.BaseModel;
import com.rig.model.Consultor;
import com.rig.model.Credito;
import com.rig.model.FormaDePagamento;
import com.rig.model.Supervisor;

@Entity
@Table(name = "VendaFibra")
@AttributeOverride(name = "id", column = @Column(name = "vendaFibraId"))
public class VendaFibra extends BaseModel{
	
	private static final long serialVersionUID = 8175090472412750747L;

	private Consultor consultor;
	private Supervisor supervisor;
	private Credito credito;
	private PlanoVoz planoVoz;
	private PlanoDados planoDados;
	private PlanosTv planosTv;
	private FormaDePagamento formaDePagamento;
	private BigDecimal valor = BigDecimal.ZERO;
	private String tipoHabilitacao;
	private String numeroIstancia;
	private Date data;
	private String cheklist;
	private String iqv;
	private String armario;
	private String observacao;
	
	private String nome;
	private String solicitante;
	private String documentoReceitaFederal;
	private String celular1;
	private String celular2;
	private String celular3;
	
	private String cep;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	
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
	@Enumerated(EnumType.STRING)
	@Column(name = "plano_voz", length = 15)
	public PlanoVoz getPlanoVoz() {
		return planoVoz;
	}

	public void setPlanoVoz(PlanoVoz planoVoz) {
		this.planoVoz = planoVoz;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "plano_dados", length = 15)
	public PlanoDados getPlanoDados() {
		return planoDados;
	}

	public void setPlanoDados(PlanoDados planoDados) {
		this.planoDados = planoDados;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "plano_tv", length = 15)
	public PlanosTv getPlanosTv() {
		return planosTv;
	}

	public void setPlanosTv(PlanosTv planosTv) {
		this.planosTv = planosTv;
	}

	@NotNull
	@Column(length = 20)
	@Enumerated(EnumType.STRING)
	public Credito getCredito() {
		return credito;
	}

	public void setCredito(Credito credito) {
		this.credito = credito;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "forma_de_pagamento", length = 25)
	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	@NotNull
	@Column(nullable = false, precision = 10, scale = 2)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "tipo_habilitacao", length = 15)
	public String getTipoHabilitacao() {
		return tipoHabilitacao;
	}

	public void setTipoHabilitacao(String tipoHabilitacao) {
		this.tipoHabilitacao = tipoHabilitacao;
	}

	@NotNull
	@NotEmpty
	@Column(name = "numero_instancia")
	public String getNumeroIstancia() {
		return numeroIstancia;
	}

	public void setNumeroIstancia(String numeroIstancia) {
		this.numeroIstancia = numeroIstancia;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(length = 60)
	public String getCheklist() {
		return cheklist;
	}

	public void setCheklist(String cheklist) {
		this.cheklist = cheklist;
	}

	@Column(length = 20)
	public String getIqv() {
		return iqv;
	}

	public void setIqv(String iqv) {
		this.iqv = iqv;
	}

	@Column(length = 4)
	public String getArmario() {
		return armario;
	}

	public void setArmario(String armario) {
		this.armario = armario;
	}

	@Column(length = 200)
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@NotNull
	@NotBlank
	@Column(length = 120, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 120)
	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	@NotEmpty
	@NotNull
	@Column(name = "doc_receita_federal", nullable = false, length = 14)
	public String getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}

	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}

	@NotNull
	@Column(length = 11, nullable = false)
	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	
	@Column(length = 11)
	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	@Column(length = 11)
	public String getCelular3() {
		return celular3;
	}

	public void setCelular3(String celular3) {
		this.celular3 = celular3;
	}
	
	@Column(length = 9)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@NotEmpty
	@NotBlank
	@Column(length = 120, nullable = false)
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Column(length = 60)
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Column(length = 100)
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	@Column(length = 25)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
