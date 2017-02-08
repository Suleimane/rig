package com.rig.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.rig.model.movel.VendaMovel;

public class VendaMovelDao extends JpaDaoGenerico<VendaMovel> {

	@PersistenceContext
	private EntityManager maneger;

	@Override
	protected Class<VendaMovel> getClasseEntidade() {
		return VendaMovel.class;
	}

	public void salvarVendaMovel(VendaMovel vendaMovel) {
		super.salvarEntidade(vendaMovel);
		super.entityManager.flush();
	}

	public List<VendaMovel> selecionarVendasMovel() {
		return maneger.createQuery(
				"from VendaMovel vm join fetch vm.consultor", VendaMovel.class)
				.getResultList();
	}

	public void excluirVendaMovel(VendaMovel vendaMovel) {
		super.excluirEntidade(vendaMovel);
	}

}
