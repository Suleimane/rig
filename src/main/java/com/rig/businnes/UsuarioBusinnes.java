package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.rig.dao.UsuarioDao;
import com.rig.model.Funcionario;
import com.rig.model.Usuario;

public class UsuarioBusinnes {
	@Inject
	private UsuarioDao usuarioDao;

	@Transactional
	public void salvarUsuario(Usuario usuario) {
		usuarioDao.salvarUsurio(usuario);
	}

	public List<Usuario> selecionarUsuarios() {
		return usuarioDao.selecionarUsuarios();
	}

	public List<Funcionario> carregarFuncionarios() {
		return usuarioDao.carregarFuncionarios();
	}

	@Transactional
	public void excluirUsuario(Usuario usuario) {
		usuarioDao.excluiUsuario(usuario);
	}
}
