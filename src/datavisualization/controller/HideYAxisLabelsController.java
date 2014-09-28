package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class HideYAxisLabelsController{

    public HideYAxisLabelsController() {} 
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		GraphProperties p = GraphProperties.getGraphProperties();
		p.setProperty(ICommonProperties.yAxisLabel, GraphProperties.FALSE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
