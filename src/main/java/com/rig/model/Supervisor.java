package com.rig.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.rig.model.fibra.VendaFibra;
import com.rig.model.movel.VendaMovel;

@Entity
@Table(name = "Supervisor")
@AttributeOverride(name = "id", column = @Column(name = "supervisorId"))
public class Supervisor extends BaseModel {

	private static final long serialVersionUID = 7069233168808034492L;

	private Funcionario funcionario;
	private Funcionario gerente;
	private List<Consultor> consultores;
	private List<VendaFibra> vendas;
	private List<VendaMovel> vendasMovel;
	private Integer metaDoMes = 0;
	private Integer metaDiaria = 0;

	@NotNull
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "funcionarioId")
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	@JoinColumn(name = "gerenteId")
	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}

	@OneToMany(mappedBy = "supervisor")
	public List<Consultor> getConsultores() {
		return consultores;
	}

	public void setConsultores(List<Consultor> consultores) {
		this.consultores = consultores;
	}
	
	@OneToMany(mappedBy = "supervisor")
	public List<VendaFibra> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaFibra> vendas) {
		this.vendas = vendas;
	}

	@OneToMany(mappedBy = "supervisor")
	public List<VendaMovel> getVendasMovel() {
		return vendasMovel;
	}

	public void setVendasMovel(List<VendaMovel> vendasMovel) {
		this.vendasMovel = vendasMovel;
	}

	@Max(250)
	@Min(100)
	@Column(name = "meta_mes", length = 3)
	public Integer getMetaDoMes() {
		return metaDoMes;
	}

	public void setMetaDoMes(Integer metaDoMes) {
		this.metaDoMes = metaDoMes;
	}

	@Max(12)
	@Min(3)
	@Column(name = "meta_dia", length = 2)
	public Integer getMetaDiaria() {
		return metaDiaria;
	}

	public void setMetaDiaria(Integer metaDiaria) {
		this.metaDiaria = metaDiaria;
	}
}
