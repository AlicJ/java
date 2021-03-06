package lab3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CounterTest {

	private Counter c1;
	private Counter c2;
	
	@Before
	public void setup() {
		c1 = new Counter("c1");
		c2 = new Counter("c2");
		
		for (int i=0; i<10; i++)
			c1.increment();
		for (int i=0; i<5; i++)
			c2.increment();
	}

	@Test
	public void testTally() {
		assertTrue(c1.tally() == 10);
		assertTrue(c2.tally() == 5);
	}

	@Test
	public void testToString() {
		assertEquals(c1.toString(), c1.tally() + " c1");
		assertEquals(c2.toString(), c2.tally() + " c2");
	}

	@Test
	public void testCompareTo() {
		assertEquals(c1.compareTo(c2), 1);
		assertEquals(c2.compareTo(c1), -1);
		assertEquals(new Counter("t1").compareTo(new Counter("t2")), 0);
	}

}
