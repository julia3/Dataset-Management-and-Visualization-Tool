package datavisualization.controller;

import javax.swing.DefaultListModel;
import datavisualization.view.*;
import datavisualization.model.*;

public class DeleteDataController {
    DataSet dataset;
	
	public DeleteDataController(DataSet dataset) {
		this.dataset = dataset;
	}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		dataOperationGUI.getDataField().setText("");
		
		int idx=dataOperationGUI.getDataList().getSelectedIndex();
		
		if (idx == -1||idx>dataset.size()) {
			return false;
		}	
		dataset.removeNthData(idx);

		DefaultListModel<Value> list = (DefaultListModel) dataOperationGUI.getDataList().getModel();	
		list.remove(idx);
		
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
