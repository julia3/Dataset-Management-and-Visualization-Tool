package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.model.DataSet;
import datavisualization.view.*;

import org.junit.Test;

public class testShowCartesianPlotController {

	@Test
	public void test() {

		ShowGraphController scpc=new ShowGraphController();
		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset= (DataSet) dataOperationGUI.getDataSet();
		
		AddNewDataController andc=new AddNewDataController(dataset);
		
		dataOperationGUI.setVisible(true);
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		
		boolean testTrue=scpc.act(dataOperationGUI, GraphEnum.CartesianGraph);
		assertTrue(testTrue);
		
		
	}

}
