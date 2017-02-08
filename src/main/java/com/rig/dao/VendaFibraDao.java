package com.rig.dao;

import java.util.List;

import com.rig.model.fibra.VendaFibra;

public class VendaFibraDao extends JpaDaoGenerico<VendaFibra> {

	@Override
	protected Class<VendaFibra> getClasseEntidade() {
		return VendaFibra.class;
	}

	public void salvarVendaFibra(VendaFibra vendaFibra) {
		super.salvarEntidade(vendaFibra);
		// super.entityManager.flush();
	}

	public List<VendaFibra> selecionarVendasFibra() {
		return super.selecionarTodos();
	}

	public void excluirVendaFibra(VendaFibra vendaFibra) {
		super.excluirEntidade(vendaFibra);
	}

}
