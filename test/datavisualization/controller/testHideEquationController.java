package datavisualization.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import datavisualization.model.DataSet;
import datavisualization.view.*;

public class testHideEquationController {

	@Test
	public void test() {

		HideEquationController hqc = new HideEquationController();
		DataOperationGUI dataOperationGUI = new DataOperationGUI();
		dataOperationGUI.setVisible(true);

		DataSet dataset=new DataSet();
		
		AddNewDataController andc=new AddNewDataController(dataset);
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("2,2");
		andc.act(dataOperationGUI);
		
		ShowGraphController scpc=new ShowGraphController();
		scpc.act(dataOperationGUI, GraphEnum.CartesianGraph);
		
		boolean testTrue = hqc.act(dataOperationGUI);
		assertTrue(testTrue);
	}

}