package com.rig.model;

public enum Credito {
	
	APROVADO("Aprovado"), FND("FND"), GRAUMAXIMO("Grau Máximo");

	private String descricao;

	Credito(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
