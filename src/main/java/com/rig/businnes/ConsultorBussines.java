package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.rig.dao.ConsultorDao;
import com.rig.model.Consultor;
import com.rig.model.Funcionario;
import com.rig.model.Supervisor;

public class ConsultorBussines {
	@Inject
	private ConsultorDao consultorDao;

	@Transactional
	public void salvarConsultor(Consultor consultor) {
		consultorDao.salvarConsultor(consultor);
	}

	public List<Consultor> selecionarConsultores() {
		return consultorDao.selecionarConsultores();
	}

	public List<Funcionario> selecionarConsFuncionarios() {
		return consultorDao.selecionarConsFuncionarios();
	}

	@Transactional
	public void excluirConsutor(Consultor consultor) {
		consultorDao.excluirConsultor(consultor);
	}

	public List<Consultor> selecionarConsultores(Supervisor supervisor) {
		return consultorDao.selecionarConsultores(supervisor);
	}

}
