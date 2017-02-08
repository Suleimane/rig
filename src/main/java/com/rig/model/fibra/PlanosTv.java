package com.rig.model.fibra;

public enum PlanosTv {

	SUPER("Pacote Super HD"), 
	ULTRA("Pacote Ultra HD"), 
	ULTIMATE("Pacote Ultimate"), 
	ULTRAFUTEBOL("Tv Ultra HD Futebol"), 
	FULLHD("Tv Full HD");

	private String descricao;

	PlanosTv(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
