package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.rig.model.Consultor;
import com.rig.model.Funcionario;
import com.rig.model.Supervisor;

public class ConsultorDao extends JpaDaoGenerico<Consultor> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected Class<Consultor> getClasseEntidade() {
		return Consultor.class;
	}

	public void salvarConsultor(Consultor consultor) {
		super.salvarEntidade(consultor);
	}

	public List<Funcionario> selecionarConsFuncionarios() {
		return manager
				.createQuery(
						"select f from Funcionario f LEFT JOIN f.consultor c where c = null and f.dataDemissao = null and f.cargo = 'CONSULTOR'",
						Funcionario.class).getResultList();
	}

	public List<Consultor> selecionarConsultores() {
		return manager.createQuery("from Consultor c join fetch c.funcionario",
				Consultor.class).getResultList();
	}

	public void excluirConsultor(Consultor consultor) {
		super.excluirEntidade(consultor);
	}

	@SuppressWarnings("unchecked")
	public List<Consultor> selecionarConsultores(Supervisor supervisor) {
		String jpql = "from Consultor where supervisor = :supervisor";
		Query query = manager.createQuery(jpql);
		query.setParameter("supervisor", supervisor);
		return query.getResultList();
	}

}
