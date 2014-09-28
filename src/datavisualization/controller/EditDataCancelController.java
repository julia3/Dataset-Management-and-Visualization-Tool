package datavisualization.controller;

import datavisualization.view.EditDataSet;

public class EditDataCancelController {
	
	public boolean act(EditDataSet editDataSet) {
		editDataSet.setCanceled(true);
		editDataSet.setVisible(false);
		
		return true;
	}
}
