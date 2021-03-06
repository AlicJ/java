package lab3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MoneyTest {
	
	private Money f12CAD;
	private Money f14CAD;
	
	@Before
	public void setup() throws Exception {
		f12CAD = new Money(12, "CAD");
		f14CAD = new Money(14, "CAD");
	}


	@Test
	public void testAmount() {
		assertTrue(f12CAD.amount() == 12);
		assertTrue(f14CAD.amount() == 14);
	}

	@Test
	public void testCurrency() {
		assertTrue(f12CAD.currency() == "CAD");
		assertTrue(f14CAD.currency() == "CAD");
	}

	@Test
	public void testAdd() {
		Money expected = new Money(26, "CAD");
		try {
			Money result = f12CAD.add(f14CAD);
			assertTrue(expected.equals(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR!");
			System.out.println(e.getMessage());
		}
		
		try {
			Money result = f12CAD.add(new Money(14, "RMB"));
			assertTrue(expected.equals(result));
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println("ERROR!");
//			System.out.println(e.getMessage());
			assertTrue(e.getMessage().equals(("Cannot add different currency togethor.")));
		}
	}

	@Test
	public void testEqualsObject() {
		assertTrue(!f12CAD.equals(null));
		assertEquals(f12CAD, new Money(12, "CAD"));
		assertEquals(f12CAD, f12CAD);
		assertTrue(!f12CAD.equals(f14CAD));
		assertTrue(!f12CAD.equals("f12CAD"));
	}

}
