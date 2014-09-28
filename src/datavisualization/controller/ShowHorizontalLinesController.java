package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class ShowHorizontalLinesController{
	public ShowHorizontalLinesController() {}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		GraphProperties p = GraphProperties.getGraphProperties();
		p.setProperty(ICommonProperties.horizontalLines, GraphProperties.TRUE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}

}
