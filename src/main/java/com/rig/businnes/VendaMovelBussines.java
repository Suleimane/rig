package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.rig.dao.VendaMovelDao;
import com.rig.model.movel.VendaMovel;

public class VendaMovelBussines {

	@Inject
	private VendaMovelDao vendaMovelDao;

	@Transactional
	public void salvarVendaMovel(VendaMovel vendaMovel) {
		vendaMovelDao.salvarVendaMovel(vendaMovel);
	}

	public List<VendaMovel> selecionarVendasMovel() {
		return vendaMovelDao.selecionarVendasMovel();
	}

	@Transactional
	public void excluirVendaMovel(VendaMovel vendaMovel) {
		vendaMovelDao.excluirVendaMovel(vendaMovel);
	}
}
