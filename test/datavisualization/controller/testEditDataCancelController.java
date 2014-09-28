package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.view.*;

import org.junit.Test;

public class testEditDataCancelController {

	@Test
	public void test() {

		EditDataSet eds=new EditDataSet();
		eds.setVisible(true);
		EditDataCancelController edcc= new EditDataCancelController();
		
		boolean testTrue=edcc.act(eds);
		assertTrue(testTrue);
	}

}
