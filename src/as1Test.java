import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

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
		File myFile = new File("test.txt");
		Scanner scan = new Scanner("test.txt");
		Map map = new HashMap(10, 1);
		Hashtable<String, Integer> table = new Hashtable<>(1);
		
		assertFalse(as1.readFile(0,scan,table));
		assertFalse(as1.readFile(-1,scan,table));
		assertTrue(as1.readFile(5,scan,table));
	}
	
	public void testFindKey(){
		File myFile = new File("test.txt");
		Scanner scan = new Scanner("test.txt");
		Map map = new HashMap(10, 1);
		Hashtable<String, Integer> table = new Hashtable<>(1);
		
		assertFalse(as1.findKey(0,scan,table));
		assertFalse(as1.findKey(-4,scan,table));
		assertTrue(as1.findKey(3,scan,table));
	}

	private boolean main(String[] strings) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
