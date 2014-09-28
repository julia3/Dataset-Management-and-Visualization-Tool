package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.model.DataSet;
import datavisualization.view.*;

import org.junit.Test;

public class testShowColumnGraphController {

	@Test
	public void test() {

		ShowGraphController scgc=new ShowGraphController();
		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset= (DataSet) dataOperationGUI.getDataSet();
		
		AddNewDataController andc= new AddNewDataController(dataset);
		
		dataOperationGUI.setVisible(true);
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("2,2");
		andc.act(dataOperationGUI);
		boolean testTrue=scgc.act(dataOperationGUI, GraphEnum.ColumnGraph);
		assertTrue(testTrue);
		
		
	}

}
