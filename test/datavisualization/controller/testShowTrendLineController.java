package datavisualization.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import datavisualization.model.DataSet;
import datavisualization.view.*;

public class testShowTrendLineController {

	@Test
	public void test() {

		ShowTrendLineController stlc = new ShowTrendLineController();

		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset=(DataSet) dataOperationGUI.getDataSet();
		AddNewDataController andc=new AddNewDataController(dataset);
		dataOperationGUI.setVisible(true);

		dataOperationGUI.getDataField().setText("1,2");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("-1,2");
		andc.act(dataOperationGUI);

		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("2,2");
		andc.act(dataOperationGUI);
		
		ShowGraphController scpc=new ShowGraphController();
		scpc.act(dataOperationGUI, GraphEnum.CartesianGraph);
		
		boolean testTrue = stlc.act(dataOperationGUI);
		assertTrue(testTrue);
	}

}
