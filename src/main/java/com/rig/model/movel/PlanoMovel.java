package com.rig.model.movel;

public enum PlanoMovel {

	CONTROLE("Controle"), POS("Pos");

	private String decricao;

	PlanoMovel(String descricao) {
		this.decricao = descricao;
	}

	public String getDecricao() {
		return decricao;
	}

}
