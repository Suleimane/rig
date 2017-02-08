package com.rig.managedbeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.rig.util.DataUtil;

@ManagedBean
public class GraficoAnualMovel implements Serializable {

	private static final long serialVersionUID = -8686647553680504623L;

	private BarChartModel barChartModel;

	@PostConstruct
	public void init() {
		createBarModels();
	}

	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries vendasVivoFibra = new ChartSeries();
		vendasVivoFibra.setLabel("móvel");
		for (String mes : DataUtil.listaDeMeses()) {
			vendasVivoFibra.set(mes, 140);
		}
		model.setShowPointLabels(true);
		model.addSeries(vendasVivoFibra);

		return model;
	}

	public void createBarModels() {
		createBarModel();
	}

	public void createBarModel() {
		barChartModel = initBarModel();

		barChartModel.setLegendPosition("ne");

		Axis xAxis = barChartModel.getAxis(AxisType.X);
		xAxis.setLabel("Meses");

		Axis yAxis = barChartModel.getAxis(AxisType.Y);
		yAxis.setLabel("Vendas");

		yAxis.setMin(0);
		yAxis.setMax(300);
	}

}
