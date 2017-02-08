package com.rig.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Consultor")
@AttributeOverride(name = "id", column = @Column(name = "consultorId"))
public class Consultor extends BaseModel {

	private static final long serialVersionUID = 1214749124340248812L;

	private Funcionario funcionario;
	private Supervisor supervisor;
	private List<VendaFibra> vendas;
	private List<VendaMovel> vendasMovel;
	private Integer metaDoMes = 0;
	private Integer metaDiaria = 0;

	@NotNull
	@JoinColumn(name = "funcionarioId")
	@OneToOne(optional = false)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@NotNull
	@JoinColumn(name = "supervisorId")
	@ManyToOne(optional = false)
	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	@OneToMany(mappedBy = "consultor")
	public List<VendaFibra> getVendas() {
		return vendas;
	}

	public void setVendas(List<VendaFibra> vendas) {
		this.vendas = vendas;
	}

	@OneToMany(mappedBy = "consultor")
	public List<VendaMovel> getVendasMovel() {
		return vendasMovel;
	}

	public void setVendasMovel(List<VendaMovel> vendasMovel) {
		this.vendasMovel = vendasMovel;
	}

	@Max(50)
	@Min(15)
	@Column(name = "meta_mes", length = 2)
	public Integer getMetaDoMes() {
		return metaDoMes;
	}

	public void setMetaDoMes(Integer metaDoMes) {
		this.metaDoMes = metaDoMes;
	}

	@Max(9)
	@Min(1)
	@Column(name = "meta_dia", length = 2)
	public Integer getMetaDiaria() {
		return metaDiaria;
	}

	public void setMetaDiaria(Integer metaDiaria) {
		this.metaDiaria = metaDiaria;
	}

}
