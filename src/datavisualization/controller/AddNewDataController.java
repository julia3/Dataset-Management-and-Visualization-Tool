package datavisualization.controller;

import javax.swing.DefaultListModel;

import datavisualization.view.*;
import datavisualization.model.*;

public class AddNewDataController {
	DataSet dataset;
	
	public AddNewDataController(DataSet dateset) {
		this.dataset = dateset;
	}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		Value dataToAdd = Value.fromString(dataOperationGUI.getDataField().getText());
		dataOperationGUI.getDataField().setText("");
		
		if (dataToAdd==null){
			return false;
		}
		if (dataset.size()>=dataset.max())
		{
			return false;
		}
		
		int idx = dataset.addData(dataToAdd);
		
		DefaultListModel<Value> list = (DefaultListModel) dataOperationGUI.getDataList().getModel();
		list.add(idx, dataToAdd);
		
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
