package com.rig.model.movel;

public enum PlanoVozMovel {
	
	CEM("100 MIN"), CINQUENTA("50 MIN");
	
	private String descricao;

	PlanoVozMovel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
