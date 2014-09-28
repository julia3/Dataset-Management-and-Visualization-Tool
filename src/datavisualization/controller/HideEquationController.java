package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class HideEquationController{
    public HideEquationController() {}
	
	public boolean act(DataOperationGUI dataOperationGUI) {
		
		GraphProperties p = GraphProperties.getGraphProperties();
		p.put(ICommonProperties.trendLineEquationVisible, GraphProperties.FALSE);
		dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
		dataOperationGUI.getGraphPanel().repaint();
		return true;
	}


}
