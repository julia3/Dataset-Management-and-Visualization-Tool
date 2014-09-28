package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class ShowYAxisLabelsController{

    public ShowYAxisLabelsController() {}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		GraphProperties p = GraphProperties.getGraphProperties();
		p.setProperty(ICommonProperties.yAxisLabel, GraphProperties.TRUE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}
}
