package Lab2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestProg6 {
	@Test
	public void testremoveDup() {
		Prog6 p6 = new Prog6();
		String[] testArray = {"horse", "dog", "cat", "horse","dog"};
		String[] result = p6.removeDups(testArray);
		String[] expected = {"horse", "dog", "cat"};
		
		for(int i=0;i<expected.length;i++)
		{
			assertTrue(expected[i].equals(result[i]));			
		}
		
		
				
	}	
}
