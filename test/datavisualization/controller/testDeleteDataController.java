package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.model.*;
import datavisualization.controller.*;
import datavisualization.view.*;

import org.junit.Test;

public class testDeleteDataController {

	@Test
	public void test() {
		
		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset=(DataSet) dataOperationGUI.getDataSet();
		AddNewDataController andc=new AddNewDataController(dataset);
		DeleteDataController ddc=new DeleteDataController(dataset);
		dataOperationGUI.setVisible(true);
		
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		
        boolean testTrue=ddc.act(dataOperationGUI);
        
	}

}
