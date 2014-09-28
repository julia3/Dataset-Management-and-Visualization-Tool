package datavisualization.view;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import datavisualization.model.*;
import dataset.*;

public class MultipleLines extends Graph {
	int originX;
	int originY;
	int maxXAxisValue;
	int maxYAxisValue;
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		originX = LEFT_MARGIN;
		originY = contentHeight / 2 + TOP_MARGIN;
		maxXAxisValue = getMaximumXAxisValue(dataset.size());
		maxYAxisValue = getMaximumYAxisValue();
	}

	@Override
	public void drawAxes() {
		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(2.0f));

		// 1. X axis
		g.drawLine(0, originY, width, originY);

		// 2. Y axis
		g.drawLine(LEFT_MARGIN, 0, LEFT_MARGIN, height);

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
		//Draw X axis Scale
		for (int i = 1; i <= size; i++) {
			g.drawLine(originX + i * contentWidth / (size + 1), originY,
					originX + i * contentWidth / (size + 1), originY
							+ SCALE_LENGTH);
		}
		//Draw X axis scale value
		for (int i = 1; i <= size; i++) {
			g.drawString("" + i, originX + i * contentWidth / (size + 1),
					originY + TOP_MARGIN);
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
				g.drawLine(originX, originY + i * contentHeight / 10, width, originY + i * contentHeight / 10);
				g.drawLine(originX, originY - i * contentHeight / 10, width, originY - i * contentHeight / 10);
			}
		}
	}
	@Override
	protected void drawContent() {
		// TODO Auto-generated method stub		
		for (int i = 0; i < dataset.size(); i++) {
			
			//X
			
			Value dataX = valueToMultipleLinesValue(dataset.getCoordinate(i, 0), i);
			g.setColor(Color.BLUE);
			((Graphics2D) g).setStroke(new BasicStroke(2.0f));
			g.drawRect((int)(dataX.getX()), (int)(dataX.getY()), 2, 2);
			
			if(i>=1){
				Value dataXX = valueToMultipleLinesValue(dataset.getCoordinate(i-1, 0), i-1);
				((Graphics2D) g).setStroke(new BasicStroke(1.0f));
				g.drawLine((int)(dataXX.getX()), (int)(dataXX.getY()),(int)(dataX.getX()), (int)(dataX.getY()));
			}
           
			//Y
			
			Value dataY = valueToMultipleLinesValue(dataset.getCoordinate(i, 1), i);
			g.setColor(Color.RED);
			((Graphics2D) g).setStroke(new BasicStroke(2.0f));
		    
			g.drawRect((int)(dataY.getX()), (int)(dataY.getY()), 2, 2);
			if(i>=1){
				Value dataYY = valueToMultipleLinesValue(dataset.getCoordinate(i-1, 1), i-1);
				((Graphics2D) g).setStroke(new BasicStroke(1.0f));
				g.drawLine((int)(dataYY.getX()), (int)(dataYY.getY()),(int)(dataY.getX()), (int)(dataY.getY()));
			}

		}
		
	}
	double getScaleX() {
		return contentWidth / (double) maxXAxisValue;
	}

	double getScaleY() {
		return contentHeight / (double) (maxYAxisValue * 2);
	}

	// maximum X axis value always be dataset size plus 1
	private int getMaximumXAxisValue(int size) {
		return size + 1;
	}

	// maximum Y axis value always be 110% of maximum data value
	private int getMaximumYAxisValue() {
		int absMinX = (int) Math.floor(Math.abs(dataset.getMinX()) * 1.1f);
		int absMaxX = (int) Math.floor(Math.abs(dataset.getMaxX()) * 1.1f);
		int tempX = absMinX > absMaxX ? absMinX : absMaxX;
		int absMinY = (int) Math.floor(Math.abs(dataset.getMinY()) * 1.1f);
		int absMaxY = (int) Math.floor(Math.abs(dataset.getMaxY()) * 1.1f);
		int tempY = absMinY > absMaxY ? absMinY : absMaxY;
		int delta = tempX > tempY ? tempX : tempY;
		if (delta % 10 != 0)
			delta = (delta / 10 + 1) * 10;

		return delta;
	}
	private Value valueToMultipleLinesValue(double value, int index) {
		double x = originX + (index + 1) * getScaleX();
		double y = originY - value * getScaleY();
		return new Value((float)x,(float)y);
	}

}
