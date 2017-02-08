package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rig.model.Funcionario;
import com.rig.model.Usuario;

public class UsuarioDao extends JpaDaoGenerico<Usuario> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	protected Class<Usuario> getClasseEntidade() {
		return Usuario.class;
	}

	public void salvarUsurio(Usuario usuario) {
		super.salvarEntidade(usuario);
	}

	public List<Usuario> selecionarUsuarios() {
		return manager.createQuery("from Usuario u join fetch u.funcionario",
				Usuario.class).getResultList();
	}

	public void excluiUsuario(Usuario usuario) {
		super.excluirEntidade(usuario);
	}

	public List<Funcionario> carregarFuncionarios() {
		return manager
				.createQuery(
						"select f from Funcionario f LEFT JOIN f.usuario u where u = null and f.dataDemissao = null and f.cargo <> 'CONSULTOR'",
						Funcionario.class).getResultList();
	}
}
