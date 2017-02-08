package com.rig.filter;

import java.io.Serializable;

public class FuncionarioFilter implements Serializable {

	private static final long serialVersionUID = -4251137108029419962L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
