package datavisualization.controller;

import properties.ApplicationProperties;
import properties.GraphProperties;
import dataset.IGraph;
import datavisualization.view.*;


public class ShowGraphController {

	public boolean act(DataOperationGUI gui, GraphEnum graphType) {
		IGraph graph = null;
		ApplicationProperties properties = ApplicationProperties.getApplicationProperties();
		String graphClassName = new String();
		
		switch(graphType) {
		case CartesianGraph:
			gui.getShowTrendLineButton().setEnabled(true);
			gui.getHideTrendLineButton().setEnabled(true);
			gui.getShowEquationButton().setEnabled(false);
			gui.getHideEquationButton().setEnabled(false);
			
		    gui.getShowXAxisButton().setSelected(true);
			gui.getShowYAxisButton().setSelected(true);
			gui.getShowHorizontalLinesButton().setSelected(true);
			gui.getHideTrendLineButton().setSelected(true);				
			gui.getHideEquationButton().setSelected(true);
			graphClassName = properties.getCartesianClassName();
			break;
		case ColumnGraph:
			gui.getShowTrendLineButton().setEnabled(false);
			gui.getHideTrendLineButton().setEnabled(false);
			gui.getShowEquationButton().setEnabled(false);
			gui.getHideEquationButton().setEnabled(false);
			
			gui.getShowXAxisButton().setSelected(true);
			gui.getShowYAxisButton().setSelected(true);
			gui.getShowHorizontalLinesButton().setSelected(true);
			gui.getHideTrendLineButton().setSelected(true);				
			gui.getHideEquationButton().setSelected(true);
			graphClassName = properties.getColumnClassName();
			break;
		case HorizontalBarGraph:
			gui.getShowTrendLineButton().setEnabled(false);
			gui.getHideTrendLineButton().setEnabled(false);
			gui.getShowEquationButton().setEnabled(false);
			gui.getHideEquationButton().setEnabled(false);
			
			gui.getShowXAxisButton().setSelected(true);
			gui.getShowYAxisButton().setSelected(true);
			gui.getShowHorizontalLinesButton().setSelected(true);
			gui.getHideTrendLineButton().setSelected(true);				
			gui.getHideEquationButton().setSelected(true);
			graphClassName = properties.getHorizontalBarClassName();
			break;
		case MultipleLinesGraph:
			gui.getShowTrendLineButton().setEnabled(false);
			gui.getHideTrendLineButton().setEnabled(false);
			gui.getShowEquationButton().setEnabled(false);
			gui.getHideEquationButton().setEnabled(false);
			
			gui.getShowXAxisButton().setSelected(true);
			gui.getShowYAxisButton().setSelected(true);
			gui.getShowHorizontalLinesButton().setSelected(true);
			gui.getHideTrendLineButton().setSelected(true);				
			gui.getHideEquationButton().setSelected(true);
			graphClassName = properties.getMultipleLinesClassName();
			break;
		}
		
		try {
			Class clazz = Class.forName(graphClassName);
			graph = (IGraph)clazz.newInstance();
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		if(graph != null) {
			graph.setDataSet(gui.getDataSet());
			graph.setProperties(GraphProperties.getGraphProperties());
			GraphPanel panel = gui.getGraphPanel();
			panel.setGraph(graph);
			panel.repaint();
			return true;
		} else {
			return false;
		}
	}
}
