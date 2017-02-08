package com.rig.model.movel;

public enum PlanoDadosMovel {

	UM("1 GB"), UMEMEIO("1,5 GB"), DOIS("2 GB");

	private String descricao;

	PlanoDadosMovel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
