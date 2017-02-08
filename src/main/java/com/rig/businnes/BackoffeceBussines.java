package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;

import com.rig.dao.BackOfficeDao;
import com.rig.model.Funcionario;

public class BackoffeceBussines {

	@Inject
	private BackOfficeDao backOfficeDao;

	public List<Funcionario> selecionarBackoffices() {
		return backOfficeDao.selecionarBackoffices();
	}
}
