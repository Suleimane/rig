package com.rig.managedbeans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.context.RequestContext;
import com.rig.businnes.VendaFibraBussines;
import com.rig.model.Credito;
import com.rig.model.FormaDePagamento;
import com.rig.model.fibra.IQV;
import com.rig.model.fibra.PlanoDados;
import com.rig.model.fibra.PlanoVoz;
import com.rig.model.fibra.PlanosTv;
import com.rig.model.fibra.VendaFibra;
import com.rig.util.FacesMessages;

@ManagedBean
@ViewScoped
public class VendaFibraBean implements Serializable {

	private static final long serialVersionUID = 2873078046579305912L;

	@Inject
	private VendaFibraBussines vendaFibraBussines;
	private VendaFibra vendaFibra = new VendaFibra();
	private VendaFibra vendaFibraSelecionada;
	private List<VendaFibra> vendasFibra;

	@Inject
	private FacesMessages message;

	public void preparaCadastro() {
		this.vendaFibra = new VendaFibra();
	}

	public void salvar() {
		vendaFibraBussines.salvarVendaFibra(this.vendaFibra);
		listarVenasFibra();
		message.info("Venda salvo com sucesso!");
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frmVivoFibra:msgs", "frmVivoFibra:vendasTable"));
	}

	public void listarVenasFibra() {
		this.vendasFibra = vendaFibraBussines.selecionarVendasFibra();
	}

	public void excluir() {
		vendaFibraBussines.excluirVendaFibra(vendaFibraSelecionada);
		vendaFibraSelecionada = null;
		listarVenasFibra();
		message.info("Venda excluida com sucesso!");
	}

	public VendaFibra getVendaFibra() {
		return vendaFibra;
	}

	public void setVendaFibra(VendaFibra vendaFibra) {
		this.vendaFibra = vendaFibra;
	}

	public VendaFibra getVendaFibraSelecionada() {
		return vendaFibraSelecionada;
	}

	public void setVendaFibraSelecionada(VendaFibra vendaFibraSelecionada) {
		this.vendaFibraSelecionada = vendaFibraSelecionada;
	}

	public List<VendaFibra> getVendasFibra() {
		return vendasFibra;
	}

	public PlanoVoz[] getPlanoVoz() {
		return PlanoVoz.values();
	}

	public PlanoDados[] getPlanoDados() {
		return PlanoDados.values();
	}

	public PlanosTv[] getPlanoTv() {
		return PlanosTv.values();
	}

	public Credito[] getCredito() {
		return Credito.values();
	}

	public FormaDePagamento[] getFormaDePagamento() {
		return FormaDePagamento.values();
	}

	public IQV[] getIQV() {
		return IQV.values();
	}

}
