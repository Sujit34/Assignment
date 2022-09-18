package Lab2;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class TestProg8 {
	@Test
	public void testremoveDup() {
		int[] input = {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		int result = Prog8.minValue(input);
		int expected = -22;
		
	    assertTrue(expected == result);				
	}	
}
