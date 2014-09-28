package datavisualization.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Properties;

import javax.swing.JPanel;

import datavisualization.model.*;
import dataset.*;

public abstract class Graph implements IGraph{

	IDataSet dataset;
	JPanel panel;
	Graphics g;
	Properties properties;
	
	int width;
	int height;
	int contentHeight;
	int contentWidth;
	boolean enableXAxesLabel = true;
	boolean enableYAxesLabel = true;
	boolean enableHorizontalLines = true;
	boolean enableTrendLine = false;
	boolean enableLineEquation = false;
	
	protected static final int LEFT_MARGIN = 30;
	protected static final int RIGHT_MARGIN = 15;
	protected static final int TOP_MARGIN = 30;
	protected static final int BOTTOM_MARGIN = 15;
	protected static final int SCALE_LENGTH = 3;
	protected static final int SCALE_OFFSET = 20;
	
	Graph() {}
	
	public final void setDataSet(IDataSet ds) {
		this.dataset = ds;
	}
	
	public final void setProperties(Properties properties) {
		this.properties = properties;
		String xAxesLabelStr = properties.getProperty(ICommonProperties.xAxisLabel);
		String yAxesLabelStr = properties.getProperty(ICommonProperties.yAxisLabel);
		String horizontalLinesStr = properties.getProperty(ICommonProperties.horizontalLines);
		String trendLineStr = properties.getProperty(ICommonProperties.trendLineVisible);
		String equationStr = properties.getProperty(ICommonProperties.trendLineEquationVisible);
		enableXAxesLabel = checkProperty(xAxesLabelStr);
		enableYAxesLabel = checkProperty(yAxesLabelStr);
		enableHorizontalLines = checkProperty(horizontalLinesStr);
		enableTrendLine = checkProperty(trendLineStr);
		enableLineEquation = checkProperty(equationStr);
	}
	
	public final void draw(Graphics g, JPanel panel) {
		setVariables(g, panel);
		init();
		drawAxes();
		drawHorizontalLines();
		drawContent();
	}
	
	protected final void setVariables(Graphics g, JPanel panel) {
		this.g = g;
		this.panel = panel;
		width = panel.getWidth();
		height = panel.getHeight();
		contentWidth = width - LEFT_MARGIN - RIGHT_MARGIN;
		contentHeight = height - TOP_MARGIN - BOTTOM_MARGIN;
	}
	
	protected abstract void init();
	
	protected abstract void drawAxes();
	
	protected abstract void drawHorizontalLines();
	
	protected abstract void drawContent();
	
	private boolean checkProperty(String s) {
		if(s == null || s.equals("true"))
			return true;
		else
			return false;
	}
}
