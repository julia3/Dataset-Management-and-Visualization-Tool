package datavisualization.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class testValue {

	@Test
	public void test() {

		Value v1 = Value.fromString("1,1");
		assertTrue(v1.getX() == 1.0f && v1.getY() == 1.0f);
		Value v2 = Value.fromString(" 1, 1");
		assertTrue(v2.getX() == 1.0f && v2.getY() == 1.0f);

		Value v3 = Value.fromString(" 1. 1");
		assertNull(v3);
		
		Value v4 = Value.fromString(null);
		assertNull(v4);

		String s = v1.toString();
		assertEquals(s,"1.0,1.0");
	
	}

}
