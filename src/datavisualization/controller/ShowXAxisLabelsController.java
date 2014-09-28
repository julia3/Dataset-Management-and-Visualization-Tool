package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class ShowXAxisLabelsController{

    public ShowXAxisLabelsController() {}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		GraphProperties p = GraphProperties.getGraphProperties();
		p.setProperty(ICommonProperties.xAxisLabel, GraphProperties.TRUE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
