package com.rig.managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.rig.businnes.BackoffeceBussines;
import com.rig.model.Funcionario;


@ManagedBean
@ViewScoped
public class BackOfficeBean implements Serializable{

	private static final long serialVersionUID = -5732797597512056135L;
	
	@Inject
	private BackoffeceBussines backoffeceBussines;
	private List<Funcionario> backOffices;

	public void listarBackoffices() {
		this.backOffices = backoffeceBussines.selecionarBackoffices();
	}

	public List<Funcionario> getBackOffices() {
		return backOffices;
	}

}
