package com.rig.model;

public enum FormaDePagamento {

	BOLETO("Boleto"), CARTAO("Cartão");
	private String descricao;

	FormaDePagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
