package com.rig.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.PieChartModel;

@ManagedBean
public class GraficoMixFibra implements Serializable {

	private static final long serialVersionUID = -5264407338493885998L;

	private PieChartModel chartVoz;
	private PieChartModel chartDados;
	private PieChartModel chartTv;
	private PieChartModel chartTkup;

	@PostConstruct
	public void init() {
		createPieModels();
	}

	private void createPieModels() {
		createChartVoz();
	}

	private void createChartVoz() {
		chartVoz = new PieChartModel();
		chartVoz.set(" móvel", 154);
		chartVoz.set(" móvel local ", 98);
		chartVoz.set(" móvel br", 78);
		chartVoz.setShowDataLabels(true);
		chartVoz.setDiameter(150);
		chartVoz.setLegendPosition("2");
	}

	public PieChartModel getChartVoz() {
		return chartVoz;
	}

	public PieChartModel getChartDados() {
		return chartDados;
	}

	public PieChartModel getChartTv() {
		return chartTv;
	}

	public PieChartModel getChartTkup() {
		return chartTkup;
	}

}
