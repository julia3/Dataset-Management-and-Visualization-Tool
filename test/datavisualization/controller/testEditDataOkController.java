package datavisualization.controller;

import static org.junit.Assert.*;
import datavisualization.view.*;

import org.junit.Test;

public class testEditDataOkController {

	@Test
	public void test() {

		EditDataSet eds=new EditDataSet();
		eds.setVisible(true);
		EditDataOkController edoc= new EditDataOkController();
		
		boolean testTrue=edoc.act(eds);
		assertTrue(testTrue);
	}

}
