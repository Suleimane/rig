package com.rig.managedbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;

import com.rig.businnes.VendaMovelBussines;
import com.rig.model.FormaDePagamento;
import com.rig.model.TipoHabilitacao;
import com.rig.model.movel.CreditoMovel;
import com.rig.model.movel.PlanoDadosMovel;
import com.rig.model.movel.PlanoMovel;
import com.rig.model.movel.PlanoVozMovel;
import com.rig.model.movel.VendaMovel;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class VendaMovelBean implements Serializable {

	private static final long serialVersionUID = -192668672809483603L;

	@Inject
	private VendaMovelBussines vendaMovesBussines;
	private VendaMovel vendaMovel = new VendaMovel();
	private List<VendaMovel> vendasMovel;
	private VendaMovel vendaMovelSelecionada;

	@Inject
	private FacesMessages message;

	public void preparaCadastro() {
		this.vendaMovel = new VendaMovel();
	}

	public void salvar() {
		vendaMovesBussines.salvarVendaMovel(this.vendaMovel);
		listarVendasMovel();
		message.info("Venda salvo com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmVivoMovel:msgs",
						"frmVivoMovel:vendaMovelTable"));
	}

	public void listarVendasMovel() {
		this.vendasMovel = vendaMovesBussines.selecionarVendasMovel();
	}

	public void excluir() {
		vendaMovesBussines.excluirVendaMovel(vendaMovelSelecionada);
		vendaMovelSelecionada = null;
		listarVendasMovel();
		message.info("Venda excluido com sucesso!");
	}

	public VendaMovel getVendaMovel() {
		return vendaMovel;
	}

	public void setVendaMovel(VendaMovel vendaMovel) {
		this.vendaMovel = vendaMovel;
	}

	public VendaMovel getVendaMovelSelecionada() {
		return vendaMovelSelecionada;
	}

	public void setVendaMovelSelecionada(VendaMovel vendaMovelSelecionada) {
		this.vendaMovelSelecionada = vendaMovelSelecionada;
	}

	public List<VendaMovel> getVendasMovel() {
		return vendasMovel;
	}

	public PlanoVozMovel[] getPlanoVozMovel() {
		return PlanoVozMovel.values();
	}

	public PlanoDadosMovel[] getPlanoDadosMovel() {
		return PlanoDadosMovel.values();
	}

	public PlanoMovel[] getPlanoMovel() {
		return PlanoMovel.values();
	}

	public FormaDePagamento[] getFormaDePagamento() {
		return FormaDePagamento.values();
	}

	public CreditoMovel[] getCreditoMovel() {
		return CreditoMovel.values();
	}

	public TipoHabilitacao[] getTipoHabilitacao() {
		return TipoHabilitacao.values();
	}
}
