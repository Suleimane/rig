package com.rig.managedbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.rig.businnes.FuncionarioBusiness;
import com.rig.filter.FuncionarioFilter;
import com.rig.model.Area;
import com.rig.model.Cargo;
import com.rig.model.Funcionario;
import com.rig.model.Sexo;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable{

	private static final long serialVersionUID = 531905890724947266L;

	private Funcionario funcionario = new Funcionario();

	@Inject
	private FuncionarioBusiness funcionarioBusiness;
	private List<Funcionario> funcionarios;
	private Funcionario funcionarioSelecionado;
	@Inject
	private FuncionarioFilter filter;
	@Inject
	private FacesMessages message;

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public void salvar() {
		funcionarioBusiness.salvar(funcionario);
		listaFuncionarios();
		message.info("Funcionário salvo com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmFuncionario:msgs",
						"frmFuncionario:funcionariosTable"));
	}

	public void excluir() {
		funcionarioBusiness.excluir(funcionarioSelecionado);
		funcionarioSelecionado = null;
		listaFuncionarios();
		message.info("Funcionário excluido com sucesso!");
	}

	public void listaFuncionarios() {
		this.funcionarios = funcionarioBusiness.ativos();
	}

	public void preparaCadastro() {
		funcionario = new Funcionario();
	}

	public void pesquisarFuncionario() {
		this.funcionarios = funcionarioBusiness.pesquisarPorNome(filter);
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmFuncionario:funcionariosTable"));
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Sexo[] getSexo() {
		return Sexo.values();
	}

	public Cargo[] getCargos() {
		return Cargo.values();
	}

	public Area[] getArea() {
		return Area.values();
	}

	public FuncionarioFilter getFilter() {
		return filter;
	}

	public void setFilter(FuncionarioFilter filter) {
		this.filter = filter;
	}

}
