package com.rig.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.bytecode.internal.javassist.FieldHandled;
import org.hibernate.bytecode.internal.javassist.FieldHandler;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Funcionario")
@AttributeOverride(name = "id", column = @Column(name = "funcionarioId"))
public class Funcionario extends BaseModel implements FieldHandled {

	private static final long serialVersionUID = 2762925602904133456L;

	private String nome;
	private String sobrenome;
	private Sexo sexo;
	private Area area;
	private Cargo cargo;
	private Date dataAdmissao;
	private Date dataDemissao;
	private Supervisor supervisor;
	private Consultor consultor;
	private Usuario usuario;
	private FieldHandler handler;

	@NotNull
	@NotBlank
	@Column(length = 50, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(length = 70)
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", length = 1)
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(length = 20, nullable = false)
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_admissao")
	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date date) {
		this.dataAdmissao = date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_demissao", nullable = true)
	public Date getDataDemissao() {
		return dataDemissao;
	}

	@OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	public Supervisor getSupervisor() {
		if (this.handler != null) {
			return (Supervisor) this.handler.readObject(this, "supervisor",
					supervisor);
		}
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		if (this.handler != null) {
			this.supervisor = (Supervisor) this.handler.writeObject(this,
					"supervisor", this.supervisor, supervisor);
		}
		this.supervisor = supervisor;
	}

	@OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	public Consultor getConsultor() {
		if (this.handler != null) {
			return (Consultor) this.handler.readObject(this, "consultor",
					consultor);
		}
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		if (this.handler != null) {
			this.consultor = (Consultor) this.handler.writeObject(this,
					"consultor", this.consultor, consultor);
		}
		this.consultor = consultor;
	}

	@OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY)
	@LazyToOne(LazyToOneOption.NO_PROXY)
	public Usuario getUsuario() {
		if (this.handler != null) {
			return (Usuario) this.handler.readObject(this, "usuario", usuario);
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		if (this.handler != null) {
			this.usuario = (Usuario) this.handler.writeObject(this, "usuario",
					this.usuario, usuario);
		}
		this.usuario = usuario;
	}

	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	@Override
	public FieldHandler getFieldHandler() {
		return this.handler;
	}

	@Override
	public void setFieldHandler(FieldHandler handler) {
		this.handler = handler;
	}
}
