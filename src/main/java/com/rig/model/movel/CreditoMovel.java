package com.rig.model.movel;

public enum CreditoMovel {

	PENDENCIA("Pendência"), APROVADO("Aprovado");

	private String descricao;

	private CreditoMovel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
