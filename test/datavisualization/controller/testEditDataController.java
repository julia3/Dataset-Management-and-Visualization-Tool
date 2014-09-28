package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.model.*;
import datavisualization.controller.*;
import datavisualization.view.*;

import org.junit.Test;

public class testEditDataController {

	@Test
	public void test() {

		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset= (DataSet) dataOperationGUI.getDataSet();
		dataOperationGUI.setVisible(true);
		EditDataController edc=new EditDataController(dataset);
		AddNewDataController andc=new AddNewDataController(dataset);
		
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		
		EditDataSet eds=new EditDataSet();
		eds.setVisible(true);
		eds.setCanceled(false);

	
	}

}
