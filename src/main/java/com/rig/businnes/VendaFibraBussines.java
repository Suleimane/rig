package com.rig.businnes;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import com.rig.dao.VendaFibraDao;
import com.rig.model.fibra.VendaFibra;

public class VendaFibraBussines {

	@Inject
	private VendaFibraDao vendaFibraDao;

	@Transactional
	public void salvarVendaFibra(VendaFibra vendaFibra) {
		vendaFibraDao.salvarVendaFibra(vendaFibra);
	}

	public List<VendaFibra> selecionarVendasFibra() {
		return vendaFibraDao.selecionarVendasFibra();
	}

	@Transactional
	public void excluirVendaFibra(VendaFibra vendaFibra) {
		vendaFibraDao.excluirVendaFibra(vendaFibra);
	}

}
