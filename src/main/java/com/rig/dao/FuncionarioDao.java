package com.rig.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.rig.filter.FuncionarioFilter;
import com.rig.model.Funcionario;

public class FuncionarioDao extends JpaDaoGenerico<Funcionario> implements
		Serializable {

	private static final long serialVersionUID = 2949989036693974577L;

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected Class<Funcionario> getClasseEntidade() {
		return Funcionario.class;
	}

	public void salvarFuncionario(Funcionario funcionario) {
		super.salvarEntidade(funcionario);
	}

	public List<Funcionario> selecionarFuncionarios() {
		return super.selecionarTodos();
	}

	public void excluirFuncionario(Funcionario funcionario) {
		super.excluirEntidade(funcionario);
	}

	public List<Funcionario> funcionariosAtivos() {
		return this.manager
				.createQuery("from Funcionario where dataDemissao = null",
						Funcionario.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> filtrados(FuncionarioFilter funcionarioFilter) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Funcionario.class);
		if (StringUtils.isNotBlank(funcionarioFilter.getNome())) {
			criteria.add(Restrictions.like("nome", funcionarioFilter.getNome(),
					MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public List<Funcionario> funcionarioPorNome(String nome) {
		return this.manager
				.createQuery(
						"from Funcionario where upper(nome) like :nome and dataDemissao = null",
						Funcionario.class)
				.setParameter("nome", nome.toUpperCase() + "%").getResultList();
	}

	public Funcionario porId(Long id) {
		return manager.find(Funcionario.class, id);
	}

}
