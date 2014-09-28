package datavisualization.view;

import java.awt.Graphics;
import java.util.Properties;

import javax.swing.JPanel;

import dataset.ICommonProperties;
import dataset.IDataSet;
import dataset.IGraph;
import datavisualization.model.*;

public class GraphPanel extends JPanel{

	IDataSet dataset;
	IGraph graph;
	boolean enableCartesian;
	boolean enableColumn;

	public GraphPanel(DataSet dataset) {
		super();
		this.dataset=dataset;

	}
	public IGraph getGraph(){
		return graph;
	}
	public void setGraph(IGraph graph){
		this.graph=graph;
	}
	public IDataSet getDataSet(){
		return dataset;
	}
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(graph != null){
	        graph.draw(g,this);
		}
	}

}
