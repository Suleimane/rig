package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.rig.model.BaseModel;

public abstract class JpaDaoGenerico<T extends BaseModel> {

	/**
	 * EntityManager injetado pelo container
	 */
	@PersistenceContext(unitName = "rig")
	protected EntityManager entityManager;

	/**
	 * Utilizado pelos metodos de persistencia para a identificacao de qual
	 * classe a persistencia esta sendo feita. Utilizada na implementacao do
	 * padrao Template Method.
	 * 
	 * @return a classe da entidade a qual o DAO realiza a persistencia.
	 */
	protected abstract Class<T> getClasseEntidade();

	/**
	 * Inserir Entidade
	 * 
	 * @param entidade
	 */
	protected void inserirEntidade(T entidade) {
		entityManager.persist(entidade);
	}

	/**
	 * Atualizar Entidade
	 * 
	 * @param entidade
	 */
	protected void atualizarEntidade(T entidade) {
		entityManager.merge(entidade);
	}

	/**
	 * Decide entre salvar nova entidade ou atualizar existente
	 * 
	 * @param entidade
	 */
	protected void salvarEntidade(T entidade) {
		if (entidade.getId() == null) {
			inserirEntidade(entidade);
		} else {
			atualizarEntidade(entidade);
		}
	}
	
	/**
	 * Excluir entidade
	 * @param entidade
	 */
	protected void excluirEntidade(T entidade){
		T entity = selecionarEntidade(entidade);
		entityManager.remove(entity);
	}

	/**
	 * Selecionar todas as entidades
	 * 
	 * @return Lista de entidades
	 */
	@SuppressWarnings("unchecked")
	protected List<T> selecionarTodos() {
		Query query = entityManager.createQuery("Select e from "
				+ getClasseEntidade().getName() + " e ");
		return query.getResultList();
	}

	/**
	 * Selecionar entidade
	 * @param entidade
	 * @return
	 */
	protected T selecionarEntidade(T entidade) {
		return entityManager.find(getClasseEntidade(), entidade.getId());
	}

}
