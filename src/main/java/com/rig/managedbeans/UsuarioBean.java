package com.rig.managedbeans;

import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.rig.businnes.UsuarioBusinnes;
import com.rig.model.Funcionario;
import com.rig.model.Usuario;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class UsuarioBean {

	@Inject
	private UsuarioBusinnes usuarioBusinnes;
	private List<Usuario> usuarios;
	private List<Funcionario> funcionarios;
	private Usuario usuario = new Usuario();
	private Usuario funcionarioSelecionado;

	@Inject
	private FacesMessages message;

	public void preparaCadastro() {
		usuario = new Usuario();
	}

	public void salvar() {
		usuarioBusinnes.salvarUsuario(usuario);
		message.info("Usuário salvo com sucesso!");
		listarUsuarios();
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmFuncionario:msgs",
						"frmFuncionario:funcionariosTable"));
	}

	public void excluir() {
		usuarioBusinnes.excluirUsuario(funcionarioSelecionado);
		funcionarioSelecionado = null;
		listarUsuarios();
		message.info("Usuario excluido com sucesso!");
	}

	public void listarUsuarios() {
		this.usuarios = usuarioBusinnes.selecionarUsuarios();
		this.funcionarios = usuarioBusinnes.carregarFuncionarios();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public Usuario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Usuario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

}
