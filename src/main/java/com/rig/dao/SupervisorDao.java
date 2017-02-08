package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.rig.model.Funcionario;
import com.rig.model.Supervisor;

public class SupervisorDao extends JpaDaoGenerico<Supervisor> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected Class<Supervisor> getClasseEntidade() {
		return Supervisor.class;
	}

	public List<Supervisor> selecionarSupervisores() {
		return this.manager.createQuery(
				"from Supervisor s join fetch s.funcionario", Supervisor.class)
				.getResultList();
	}

	public List<Funcionario> selecionarSuperFuncionarios() {
		return manager
				.createQuery(
						"select f from Funcionario f LEFT JOIN f.supervisor s where s = null and f.dataDemissao = null and f.cargo = 'SUPERVISOR'",
						Funcionario.class).getResultList();
	}

	public void salvarSupervisor(Supervisor supervisor) {
		super.salvarEntidade(supervisor);
	}

	public void excluirSupervisor(Supervisor supervisor) {
		super.excluirEntidade(supervisor);
	}

}