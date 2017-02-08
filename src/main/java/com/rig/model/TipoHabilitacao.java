package com.rig.model;

public enum TipoHabilitacao {

	PORTABILIDADE("Portabilidade"), LINHANOVA("Habilitação Nova");

	private String descricao;
	
	 TipoHabilitacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
