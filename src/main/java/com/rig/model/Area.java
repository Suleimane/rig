package com.rig.model;

public enum Area {

	APOIO("APOIO"), PAP("PAP"), TLV("TLV");

	private String descricao;

	private Area(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
