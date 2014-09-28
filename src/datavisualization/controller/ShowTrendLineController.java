package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class ShowTrendLineController{

    public ShowTrendLineController() {}
	
	    public boolean act(DataOperationGUI dataOperationGUI) {
	    	GraphProperties p = GraphProperties.getGraphProperties();
			p.setProperty(ICommonProperties.trendLineVisible, GraphProperties.TRUE);
			dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
			dataOperationGUI.getGraphPanel().repaint();
		    dataOperationGUI.getShowEquationButton().setEnabled(true);
		    dataOperationGUI.getHideEquationButton().setEnabled(true);
		    return true;
	}

}
