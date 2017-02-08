package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.rig.dao.SupervisorDao;
import com.rig.model.Funcionario;
import com.rig.model.Supervisor;

public class SupervisorBusiness {

	@Inject
	private SupervisorDao supervisorDao;

	public List<Supervisor> selecionarTodos() {
		return supervisorDao.selecionarSupervisores();
	}

	public List<Funcionario> selecionarSuperFuncionarios() {
		return supervisorDao.selecionarSuperFuncionarios();
	}

	@Transactional
	public void salvarSupervisor(Supervisor supervisor) {
		supervisorDao.salvarSupervisor(supervisor);
	}

	@Transactional
	public void excluirSupervisor(Supervisor supervisor) {
		supervisorDao.excluirSupervisor(supervisor);
	}

}
