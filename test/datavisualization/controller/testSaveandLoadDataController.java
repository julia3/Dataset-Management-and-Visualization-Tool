package datavisualization.controller;

import static org.junit.Assert.*;

import java.awt.Canvas;
import java.io.File;

import org.junit.Before;
import org.junit.Test;

import datavisualization.model.*;

import datavisualization.view.*;

public class testSaveandLoadDataController {


	@Test
	public void test() {
		
	    DataOperationGUI dataOperationGUI=new DataOperationGUI();
	    dataOperationGUI.setVisible(true);

		DataSet dataset = (DataSet) dataOperationGUI.getDataSet();
		AddNewDataController andc = new AddNewDataController(dataset);
		SaveDataController sdc = new SaveDataController(dataset);
		
		dataOperationGUI.getDataField().setText("1,1");
		andc.act(dataOperationGUI);
		dataOperationGUI.getDataField().setText("2,2");
		andc.act(dataOperationGUI);
		
		File file1 = new File("saveFile");
		sdc.saveToFile(file1);
		
		LoadDataController lc1 = new LoadDataController(dataset);
		lc1.loadFromFile(dataOperationGUI, file1);
		
		Value v1 = dataset.getNth(0);
		assertTrue(v1.getX() == 1.0f && v1.getY() == 1.0f);
		Value v2 = dataset.getNth(1);
		assertTrue(v2.getX() == 2.0f && v2.getY() == 2.0f);
		
		dataset.removeAll();
		for (int i = 0; i < dataset.max() + 2; i++) {
			dataOperationGUI.getDataField().setText("" + i + "," + 2*i);
			andc.act(dataOperationGUI);
		}
		
		File file2 = null;
		boolean testFalse = sdc.saveToFile(file2);		
		assertFalse(testFalse);
		
		dataset.removeAll();


		for (int i = 0; i < dataset.max() + 2; i++) {
			dataOperationGUI.getDataField().setText("" + i + "," + 2*i);
			andc.act(dataOperationGUI);
		}
		
		File file = new File("saveFile");
		boolean result1 = sdc.saveToFile(file);		
		assertTrue(result1);
		
		LoadDataController lc2 = new LoadDataController(dataset);
		boolean result2 = lc2.loadFromFile(dataOperationGUI, file);
		assertTrue(result2);
		
		Value value = dataset.getNth(2047);
		assertTrue(value.getX() == 2047.0f && value.getY() == 4094.0f);
		
	}
	

}