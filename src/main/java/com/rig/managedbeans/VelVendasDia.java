package com.rig.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.MeterGaugeChartModel;

@ManagedBean
public class VelVendasDia implements Serializable {

	private static final long serialVersionUID = 6883767431899957703L;

	private MeterGaugeChartModel meterGaugeModel1;
	private MeterGaugeChartModel meterGaugeModel2;

	@PostConstruct
	public void init() {
		createMeterGaugeModels();
	}

	public MeterGaugeChartModel getMeterGaugeModel1() {
		return meterGaugeModel1;
	}

	public MeterGaugeChartModel getMeterGaugeModel2() {
		return meterGaugeModel2;
	}

	private MeterGaugeChartModel initMeterGaugeModel() {
		@SuppressWarnings("serial")
		List<Number> intervals = new ArrayList<Number>() {
			{
				add(20);
				add(50);
				add(120);
				add(220);
			}
		};

		return new MeterGaugeChartModel(140, intervals);
	}

	private void createMeterGaugeModels() {
		meterGaugeModel1 = initMeterGaugeModel();
		//meterGaugeModel1.setTitle("MeterGauge Chart");
		meterGaugeModel1.setGaugeLabel("v/d");

		meterGaugeModel2 = initMeterGaugeModel();
		meterGaugeModel2.setTitle("Custom Options");
		meterGaugeModel2.setSeriesColors("66cc66,93b75f,E7E658,cc6666");
		meterGaugeModel2.setGaugeLabel("km/h");
		meterGaugeModel2.setGaugeLabelPosition("bottom");
		meterGaugeModel2.setShowTickLabels(false);
		meterGaugeModel2.setLabelHeightAdjust(110);
		meterGaugeModel2.setIntervalOuterRadius(100);
	}

}
