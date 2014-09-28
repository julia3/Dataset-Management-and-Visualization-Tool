package datavisualization.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import dataset.IDataSet;
import datavisualization.model.*;


public class TrendLine {

	IDataSet dataset;
	CartesianGraph cartesianPlot;
	float a;
	float b;
	
	public TrendLine(IDataSet dataset, CartesianGraph graph) {
		this.dataset = dataset;
		this.cartesianPlot = graph;
	}

	// Use simple linear regression method to calculate the equation
	public void draw(Graphics graph) {
		
		// y = bx + a;
		float sumXY = 0;
		float sumX = 0;
		float sumY = 0;
		float sumXsquare = 0;
		for (int i = 0; i < dataset.size(); i++) {
			float x = (float)dataset.getCoordinate(i, 0);
			float y = (float)dataset.getCoordinate(i, 1);
			sumX += x;
			sumY += y;
			sumXY += x * y;
			sumXsquare += x * x; 
		}
		
		b = ( sumXY - sumX * sumY / dataset.size() ) / (sumXsquare - sumX * sumX / dataset.size());
		a = sumY / dataset.size() - b * sumX / dataset.size();
		
		int x1 = -cartesianPlot.getMaxXAxisValue();
		int y1 = (int)(b * x1 + a);
		int x2 = cartesianPlot.getMaxXAxisValue();
		int y2 = (int)(b * x2 + a);
		
		Value start = cartesianPlot.valueToCartesianPoint(x1,y1);
		Value end = cartesianPlot.valueToCartesianPoint(x2,y2);
		
		((Graphics2D)graph).setStroke(new BasicStroke(1.5f));
		graph.setColor(Color.black);
		graph.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
		
	}
	
	public void showEquation(Graphics graph) {
		
		if (graph != null) {

			graph.setColor(Color.black);
			
			if (a >= 0) {
				graph.drawString("y=" + b + "x+" + a, 0, 10);
			}
			else {
				graph.drawString("y=" + b + "x" + a, 0, 10);
			}
		}
	}
	
}
