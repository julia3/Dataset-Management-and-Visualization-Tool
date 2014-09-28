package datavisualization.controller;

import datavisualization.view.*;

public class EditDataOkController {

	public boolean act(EditDataSet editDataSet) {
		editDataSet.setCanceled(false);
		editDataSet.setVisible(false);
		return true;
	}
}
