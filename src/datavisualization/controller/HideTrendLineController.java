package datavisualization.controller;

import properties.GraphProperties;
import dataset.ICommonProperties;
import datavisualization.view.*;

public class HideTrendLineController{
	
    public HideTrendLineController() { }
	
	    public boolean act(DataOperationGUI dataOperationGUI) {

	    	GraphProperties p = GraphProperties.getGraphProperties();
			p.setProperty(ICommonProperties.trendLineVisible, GraphProperties.FALSE);
			dataOperationGUI.getGraphPanel().getGraph().setProperties(p);
			dataOperationGUI.getGraphPanel().repaint();
		    dataOperationGUI.getShowEquationButton().setEnabled(false);
		    dataOperationGUI.getHideEquationButton().setEnabled(false);

		    return true;
	}

}
