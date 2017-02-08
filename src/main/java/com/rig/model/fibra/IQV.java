package com.rig.model.fibra;

public enum IQV {
	CONSULTOR("Consultor"), BO("Back Office");

	private String descricao;

	IQV(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
