package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class HideXAxisLabelsController{

    public HideXAxisLabelsController() {} 
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		GraphProperties p = GraphProperties.getGraphProperties();
		p.setProperty(ICommonProperties.xAxisLabel, GraphProperties.FALSE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
