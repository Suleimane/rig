package com.rig.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Usuario")
@AttributeOverride(name = "id", column = @Column(name = "usuarioId"))
public class Usuario extends BaseModel {

	private static final long serialVersionUID = 722127463969470958L;

	private Funcionario funcionario;
	private String email;
	private String senha;
	private boolean status;

	@JoinColumn(name = "funcionarioId")
	@OneToOne
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@NotNull
	@NotBlank
	@Column(length = 140)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotNull
	@NotBlank
	@Column(length = 150)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(nullable = true)
	@DefaultValue("true")
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
