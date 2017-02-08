package com.rig.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class GraficoMixMovel implements Serializable {

	private static final long serialVersionUID = 7603468167170113990L;

	private PieChartModel chartModelPlano;
	private PieChartModel chartModelVoz;
	private PieChartModel chartModelDados;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	private void createPieModels() {
		createChartModelPlano();
		createChartModelVoz();
		createChartModelDados();
	}

	public void createChartModelPlano() {
		chartModelPlano = new PieChartModel();
		chartModelPlano.set("Pós", 230);
		chartModelPlano.set("Controle", 240);
		chartModelPlano.setShowDataLabels(true);
		chartModelPlano.setLegendPosition("2");
	}

	public void createChartModelVoz() {
		chartModelVoz = new PieChartModel();
		chartModelVoz.set("100min", 145);
		chartModelVoz.set("50min", 230);
		chartModelVoz.setShowDataLabels(true);
		chartModelVoz.setLegendPosition("2");
	}

	public void createChartModelDados() {
		chartModelDados = new PieChartModel();
		chartModelDados.set("1GB", 199);
		chartModelDados.set("1,5GB", 167);
		chartModelDados.set("2GB", 98);
		chartModelDados.setShowDataLabels(true);
		chartModelDados.setLegendPosition("2");
	}

	public PieChartModel getChartModelPlano() {
		return chartModelPlano;
	}

	public PieChartModel getChartModelVoz() {
		return chartModelVoz;
	}

	public PieChartModel getChartModelDados() {
		return chartModelDados;
	}

}
