package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.rig.model.Funcionario;

public class GerenteDao extends JpaDaoGenerico<Funcionario> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected Class<Funcionario> getClasseEntidade() {
		return Funcionario.class;
	}

	public List<Funcionario> selecionarGerentes() {
		return manager
				.createQuery(
						"from Funcionario where cargo='GERENTE' and dataDemissao = null",
						Funcionario.class).getResultList(); 
	}

}
