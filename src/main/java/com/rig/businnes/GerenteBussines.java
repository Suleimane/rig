package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import com.rig.dao.GerenteDao;
import com.rig.model.Funcionario;

public class GerenteBussines {

	@Inject
	private GerenteDao gerenteDao;

	public List<Funcionario> selecioanarGerentes() {
		return gerenteDao.selecionarGerentes();
	}

}
