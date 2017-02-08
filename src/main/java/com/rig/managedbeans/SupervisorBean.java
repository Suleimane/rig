package com.rig.managedbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.rig.businnes.SupervisorBusiness;
import com.rig.model.Funcionario;
import com.rig.model.Sexo;
import com.rig.model.Supervisor;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class SupervisorBean implements Serializable {

	private static final long serialVersionUID = 3480910367494723999L;

	@Inject
	private SupervisorBusiness supervisorBusiness;
	private List<Supervisor> supervisores;
	private List<Funcionario> funcionarios;
	private Supervisor funcionarioSelecionado;
	private Supervisor supervisor = new Supervisor();
	@Inject
	private FacesMessages message;

	public void preparaCadastro() {
		supervisor = new Supervisor();
	}

	public void salvar() {
		supervisorBusiness.salvarSupervisor(supervisor);
		message.info("Supervisor salvo com sucesso!");
		listarSupervisores();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmFuncionario:msgs",
						"frmFuncionario:funcionariosTable"));
	}

	public void excluir() {
		supervisorBusiness.excluirSupervisor(funcionarioSelecionado);
		funcionarioSelecionado = null;
		listarSupervisores();
		message.info("Supervisor excluido com sucesso!");
	}

	public void listarSupervisores() {
		this.supervisores = supervisorBusiness.selecionarTodos();
		this.funcionarios = supervisorBusiness.selecionarSuperFuncionarios();
	}


	public Supervisor getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Supervisor funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public List<Supervisor> getSupervisores() {
		return supervisores;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

}
