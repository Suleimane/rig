package com.rig.model;

public enum Cargo {

	GERENTE("Gerente"), SUPERVISOR("Supervisor"), CONSULTOR("Consultor"), BACKOFFICE("Back Office");

	private String descricao;

	Cargo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
