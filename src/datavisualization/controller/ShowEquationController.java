package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class ShowEquationController{
public ShowEquationController() {}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		
		GraphProperties p = GraphProperties.getGraphProperties();
		p.put(ICommonProperties.trendLineEquationVisible, GraphProperties.TRUE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}

}
