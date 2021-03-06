package sort;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
	private Word a;
	private Word b;
	private Word c;

	@Before
	public void setup() {
		a = new Word("Batman", 76);
		b = new Word("Iron man", 76);
		c = new Word("Spiderman", 98);
	}

	@Test
	public void testGetScore() {
		assertEquals(76, a.getScore());
		assertEquals(76, b.getScore());
		assertEquals(98, c.getScore());
	}

	@Test
	public void testSetScore() {
		a.setScore(78);
		assertEquals(78, a.getScore());
	}

	@Test
	public void testGetWord() {
		assertEquals("Batman", a.getWord());
		assertEquals("Iron man", b.getWord());
		assertEquals("Spiderman", c.getWord());
	}

	@Test
	public void testSetWord() {
		a.setWord("Bruce Wayne");
		assertEquals("Bruce Wayne", a.getWord());
	}

	@Test
	public void testCompareTo() {
		assertEquals(0, a.compareTo(b));
		assertEquals(1, c.compareTo(a));
		assertEquals(-1, b.compareTo(c));
	}

	@Test
	public void testToString() {
		assertEquals("{Batman,76}", a.toString());
		assertEquals("{Iron man,76}", b.toString());
		assertEquals("{Spiderman,98}", c.toString());
	}

}
