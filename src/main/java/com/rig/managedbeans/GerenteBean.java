package com.rig.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.rig.businnes.GerenteBussines;
import com.rig.model.Funcionario;

@ManagedBean
@ViewScoped
public class GerenteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private GerenteBussines gerenteBussines;
	private List<Funcionario> gerentes;

	public void listarGerentes() {
		this.gerentes = gerenteBussines.selecioanarGerentes();
	}

	public List<Funcionario> getGerentes() {
		return gerentes;
	}

}
