package com.rig.model.fibra;

public enum PlanoVoz {

	FIXOLOCAL("Fixo Local"),
	FIXOMOVELLOCAL("Fixo Móvel Local"), 
	FIXOMOVELBR("Fixo movel BR"), 
	SOHO("Soho");

	private String descricao;

	PlanoVoz(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
