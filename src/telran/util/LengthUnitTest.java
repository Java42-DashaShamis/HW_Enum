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
		//TODO
	}

	@Test
	void testConvert() {
		assertEquals(lng1, lng.convert(LengthUnit.CM));
	}

	@Test
	void testToString() {
		System.out.println(lng.toString());
	}
	@Test
	void testBetween() {
		assertEquals(lng4, LengthUnit.CM.between(lng, lng3));
	}

}
