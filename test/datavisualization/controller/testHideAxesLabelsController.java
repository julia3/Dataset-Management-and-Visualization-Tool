package datavisualization.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import datavisualization.model.DataSet;
import datavisualization.view.*;

public class testHideAxesLabelsController {

	@Test
	public void test() {

		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset=(DataSet) dataOperationGUI.getDataSet();
		AddNewDataController andc=new AddNewDataController(dataset);
		dataOperationGUI.setVisible(true);

		dataOperationGUI.getDataField().setText("1,2");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("-1,2");
		andc.act(dataOperationGUI);
		ShowGraphController sgc=new ShowGraphController();

		sgc.act(dataOperationGUI, GraphEnum.MultipleLinesGraph);
		HideXAxisLabelsController hdlc = new HideXAxisLabelsController();		
		boolean testTrue = hdlc.act(dataOperationGUI);
		assertTrue(testTrue);
	}

}
