package telran.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LengthTest {
	private static Length lng = new Length (0.2f, LengthUnit.M);
	private static Length lng1 = new Length (20f, LengthUnit.CM);
	private static Length lng2 = new Length (30f, LengthUnit.CM);
	private static Length lng3 = new Length (20f, LengthUnit.FOOT);
	private static Length lng4 = new Length (589.6f, LengthUnit.CM);

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testEqualsObject() {
		assertTrue(lng.equals(lng1));
		assertFalse(lng.equals(lng2));
		assertFalse(lng.equals(lng3));
	}

	@Test
	void testCompareTo() {
		assertEquals(0, lng.compareTo(lng1));
		assertEquals(-1, lng.compareTo(lng2));
		assertEquals(1, lng2.compareTo(lng));
		try {
			lng.compareTo(null);
			fail("There should be NullPointerException");
		} catch (NullPointerException e) {
		}
	}

	@Test
	void testConvert() {
		assertEquals(lng1, lng.convert(LengthUnit.CM));
	}

	@Test
	void testToString() {
		assertEquals("0.2M", lng.toString());
	}
	@Test
	void testBetween() {
		assertEquals(lng4, LengthUnit.CM.between(lng, lng3));
	}

}
