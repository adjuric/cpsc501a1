import static org.junit.Assert.*;

import org.junit.Test;

public class as1Test {

	@Test
	public void testMain() {
		assertTrue(main(new String[]{"test.txt","2","10"}));
		assertFalse(main(new String[]{"test.txt","10"}));
		assertFalse(main(new String[]{"test.txt","-2","10"}));
		assertFalse(main(new String[]{"test.txt","2","-3"}));
		assertFalse(main(new String[]{"","2","10"}));
		assertFalse(main(new String[]{}));
	}
	


	public void testCalcNumCompare(){
		assertEquals(1,as1.calcNumCompare( -1,10 ));
		assertEquals(1,as1.calcNumCompare( 0,10 ));
		assertEquals(24,as1.calcNumCompare( 5,10 ));
	}
	
	public void testReadFile(){
		fail("Not yet implemented");
	}
	
	public void testFindKey(){
		fail("Not yet implemented");
	}

	private boolean main(String[] strings) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
