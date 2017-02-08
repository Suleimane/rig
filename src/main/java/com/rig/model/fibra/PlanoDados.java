package com.rig.model.fibra;

public enum PlanoDados {

	QUINZE("Power 15 Mbps"), 
	VINTECINCO("Power 25 Mbps"), 
	CINQUENTA("Power 50 Mbps"), 
	CEM("Power 100 Mbps");

	private String descricao;

	PlanoDados(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
