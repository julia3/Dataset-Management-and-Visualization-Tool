package datavisualization.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import datavisualization.model.DataSet;
import datavisualization.view.*;

public class testShowHorizontalLinesController {

	@Test
	public void test() {
		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset=(DataSet) dataOperationGUI.getDataSet();
		dataOperationGUI.setVisible(true);
		AddNewDataController andc=new AddNewDataController(dataset);
	    andc.act(dataOperationGUI);
	    dataOperationGUI.getDataField().setText("1,2");
	    andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("2,3");
		andc.act(dataOperationGUI);

		ShowGraphController scpc=new ShowGraphController();
		
		scpc.act(dataOperationGUI, GraphEnum.MultipleLinesGraph);
		ShowHorizontalLinesController sdlc = new ShowHorizontalLinesController();
		boolean testTrue = sdlc.act(dataOperationGUI);
		assertTrue(testTrue);
	}

}
