package com.rig.managedbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.rig.businnes.ConsultorBussines;
import com.rig.model.Consultor;
import com.rig.model.Funcionario;
import com.rig.model.Sexo;
import com.rig.model.Supervisor;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class ConsultorBean implements Serializable {

	private static final long serialVersionUID = -3120365711213244469L;

	@Inject
	private ConsultorBussines consultorBussines;
	private List<Consultor> consultores;
	private List<Supervisor> supervisores;
	private Supervisor supervisor;
	private List<Funcionario> funcionarios;
	private Consultor consultor = new Consultor();
	private Consultor funcionarioSelecionado;
	@Inject
	private FacesMessages message;

	public void preparaCadastro() {
		consultor = new Consultor();
	}

	public void carregarConsultores() {
		consultores = consultorBussines.selecionarConsultores(supervisor);
	}

	public void salvar() {
		consultorBussines.salvarConsultor(consultor);
		message.info("Supervisor salvo com sucesso!");
		listarConsultores();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmFuncionario:msgs",
						"frmFuncionario:funcionariosTable"));
	}

	public void excluir() {
		consultorBussines.excluirConsutor(funcionarioSelecionado);
		funcionarioSelecionado = null;
		listarConsultores();
		message.info("Consultor excluido com sucesso!");
	}

	public void listarConsultores() {
		this.consultores = consultorBussines.selecionarConsultores();
		this.funcionarios = consultorBussines.selecionarConsFuncionarios();
	}

	public List<Consultor> getConsultores() {
		return consultores;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Consultor getConsultor() {
		return consultor;
	}

	public void setConsultor(Consultor consultor) {
		this.consultor = consultor;
	}

	public Consultor getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Consultor funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public List<Supervisor> getSupervisores() {
		return supervisores;
	}

	public void setSupervisores(List<Supervisor> supervisores) {
		this.supervisores = supervisores;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

}
