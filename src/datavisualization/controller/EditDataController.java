package datavisualization.controller;

import datavisualization.model.*;
import datavisualization.view.*;
import javax.swing.DefaultListModel;

public class EditDataController {
	DataSet dataset;
	
	public EditDataController(DataSet dataset){
		this.dataset=dataset;
		
	}
	
	public boolean act(DataOperationGUI dataOperationGUI){
		
		EditDataSet eds= new EditDataSet();
		eds.setModal(true);
		eds.setVisible(true);
		
		if(eds.wasCanceled()) {return false;}
		return takeAction(dataOperationGUI, eds);
	}
	
	public boolean takeAction(DataOperationGUI dataOperationGUI, EditDataSet eds){
		
		String outData = eds.getTextFieldOut().getText();
		
		int idx=dataOperationGUI.getDataList().getSelectedIndex();
		
		if(idx==-1||idx>dataset.size())
			return false;
		
		dataset.setNth(idx, Value.fromString(outData));
		
		DefaultListModel<Value> list = (DefaultListModel) dataOperationGUI.getDataList().getModel();
		list.set(idx, Value.fromString(outData));
		
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}

}
