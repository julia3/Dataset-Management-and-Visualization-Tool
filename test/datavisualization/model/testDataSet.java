package datavisualization.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDataSet {

	@Test
	public void test() {
        
		Value v1=Value.fromString("1,1");
		Value v2=Value.fromString("1,1");
		Value v3=Value.fromString("1,1");		
		
		DataSet dataset=new DataSet();
		
		dataset.addData(v1);
		dataset.addData(v2);
		dataset.addData(v3);
		
		assertTrue(dataset.getNth(0)==v1);
		assertNull(dataset.getNth(5));
		assertTrue(dataset.removeNthData(2));
		assertFalse(dataset.removeNthData(-2));
		
		dataset.removeAll();
		
		assertTrue(dataset.size()==0);
		
		
		
	}

}
