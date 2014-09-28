package datavisualization.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import datavisualization.model.DataSet;
import datavisualization.view.*;

public class testShowEquationController {

	@Test
	public void test() {

		ShowEquationController sqc = new ShowEquationController();
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
		boolean testTrue= sqc.act(dataOperationGUI);
		assertTrue(testTrue);
	}

}
