package datavisualization.view;

import java.awt.*;
import java.util.Iterator;
import java.util.Properties;

import javax.swing.JPanel;

import datavisualization.model.*;
import dataset.*;

public class CartesianGraph extends Graph{

	TrendLine trendLine;
	int originX;
	int originY;
	int maxXAxisValue;
	int maxYAxisValue;

	public int getMaxXAxisValue() { return maxXAxisValue; }

	public int getMaxYAxisValue() { return maxYAxisValue; }	

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		originX = contentWidth / 2 + LEFT_MARGIN;
		originY = contentHeight / 2 + TOP_MARGIN;
		maxXAxisValue = getMaximumXAxisValue();
		maxYAxisValue = getMaximumYAxisValue();
	}
	private int getMaximumXAxisValue() {
		int absMinX = (int) Math.floor(Math.abs(dataset.getMinX()) * 1.1f);
		int absMaxX = (int) Math.floor(Math.abs(dataset.getMaxX()) * 1.1f);
		int delta = absMinX > absMaxX ? absMinX : absMaxX;
		if (delta % 10 != 0)
			delta = (delta / 10 + 1) * 10;

		return delta;
	}
	private int getMaximumYAxisValue() {
		int absMinY = (int) Math.floor(Math.abs(dataset.getMinY()) * 1.1f);
		int absMaxY = (int) Math.floor(Math.abs(dataset.getMaxY()) * 1.1f);
		int delta = absMinY > absMaxY ? absMinY : absMaxY;
		if (delta % 10 != 0)
			delta = (delta / 10 + 1) * 10;

		return delta;
	}

	@Override
	protected void drawAxes() {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));

		// 1. X axis
		g.drawLine(0, originY, width, originY);

		// 2. Y axis
		g.drawLine(originX, 0, originX, height);

		// Draw Axes Scale

		int size = dataset.size();
		if (enableXAxesLabel) {
			drawXLabel(size);
		}
		if(enableYAxesLabel) {
			drawYLabel(size);
		}
	}
	void drawXLabel(int size) {
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		g.setColor(Color.black);
	    // 2. Draw X axis Scale
			for (int i = 1; i <= 5; i++) {
			
				g.drawLine(originX + i* contentWidth/10,originY,originX+i*contentWidth/10,originY-SCALE_LENGTH);
				g.drawLine(originX - i* contentWidth/10,originY,originX-i*contentWidth/10,originY-SCALE_LENGTH);
			}

			// 2. Draw X axis scale value

			for (int i = 1; i <= 5; i++) {
				g.drawString("" + i * maxXAxisValue / 5, originX + i* contentWidth/10, originY+TOP_MARGIN);
				g.drawString("-" + i * maxXAxisValue / 5, originX - i* contentWidth/10, originY+TOP_MARGIN);

			}
	}    


	void drawYLabel(int size) {
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		g.setColor(Color.black);
    // 2. Draw Y axis Scale
		for (int i = 1; i <= 5; i++) {
			g.drawLine(originX, originY + i * contentHeight / 10, originX
					- SCALE_LENGTH, originY + i * contentHeight / 10);
			g.drawLine(originX, originY - i * contentHeight / 10, originX
					- SCALE_LENGTH, originY - i * contentHeight / 10);
		}

		// 2. Draw Y axis scale value

		for (int i = 1; i <= 5; i++) {
			g.drawString("" + i * maxYAxisValue / 5, originX - 3
					* RIGHT_MARGIN / 2, originY - i * contentHeight / 10
					+ TOP_MARGIN / 2);
			g.drawString("-" + i * maxYAxisValue / 5, originX - 3
					* RIGHT_MARGIN / 2, originY + i * contentHeight / 10
					+ TOP_MARGIN / 2);
		}

	}

	@Override
	protected void drawHorizontalLines() {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(1.0f));
		
		if(enableHorizontalLines){
			for (int i = 1; i <= 5; i++) {
				g.drawLine(LEFT_MARGIN, originY + i * contentHeight / 10, width-RIGHT_MARGIN, originY + i * contentHeight / 10);
				g.drawLine(LEFT_MARGIN, originY - i * contentHeight / 10, width-RIGHT_MARGIN, originY - i * contentHeight / 10);
			}
		}
	}

	@Override
	protected void drawContent() {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(1.0f));
		
		for (int i = 0; i < dataset.size(); i++){
			Value data = valueToCartesianPoint((float)dataset.getCoordinate(i, 0),(float)dataset.getCoordinate(i, 1));	// Convert data to Cartesian point	
		    g.drawRect((int)(data.getX()), (int)(data.getY()), 2, 2);
		}
		if (enableTrendLine) {
			trendLine = new TrendLine(dataset, this);
			trendLine.draw(g);
			if (enableLineEquation)
				trendLine.showEquation(g);
		}
	}
	
	float getScaleX() {	return contentWidth / (float)(maxXAxisValue * 2); }
	
	float getScaleY() {	return contentHeight / (float)(maxYAxisValue * 2); }
	
	Value valueToCartesianPoint(float datax, float datay) {
		
		float x = originX + datax * getScaleX();
		float y = originY - datay * getScaleY();
		return new Value(x, y);
	}
}
