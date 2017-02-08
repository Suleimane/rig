package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.rig.dao.FuncionarioDao;
import com.rig.filter.FuncionarioFilter;
import com.rig.model.Funcionario;

public class FuncionarioBusiness {

	@Inject
	private FuncionarioDao funcionarioDao;
	
	@Transactional
	public void salvar(Funcionario funcionario) {
		funcionarioDao.salvarFuncionario(funcionario);
	}

	public List<Funcionario> selecionarTodos() {
		return funcionarioDao.selecionarFuncionarios();
	}

	@Transactional
	public void excluir(Funcionario funcionario) {
		// Verifica se existe vendas para este funcionário
		funcionarioDao.excluirFuncionario(funcionario);
	}

	public List<Funcionario> ativos() {
		return funcionarioDao.funcionariosAtivos();
	}

	public List<Funcionario> pesquisarPorNome(FuncionarioFilter filter) {
		return funcionarioDao.filtrados(filter);
	}

}
