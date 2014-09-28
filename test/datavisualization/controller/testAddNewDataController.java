package datavisualization.controller;

import static org.junit.Assert.*;
import dataset.IDataSet;
import datavisualization.model.*;
import datavisualization.controller.*;
import datavisualization.view.*;

import org.junit.Test;

public class testAddNewDataController {

	@Test
	public void test() {
		
		DataOperationGUI dataOperationGUI=new DataOperationGUI();
		DataSet dataset=(DataSet) dataOperationGUI.getDataSet();
		AddNewDataController andc=new AddNewDataController(dataset);
		dataOperationGUI.setVisible(true);
		
	    dataOperationGUI.getDataField().setText("");
	    boolean testFalse=andc.act(dataOperationGUI);
	    assertFalse(testFalse);
	    
	    dataOperationGUI.getDataField().setText("1,2");
	    boolean testTrue=andc.act(dataOperationGUI);
	    assertTrue(testTrue);
	}

}
