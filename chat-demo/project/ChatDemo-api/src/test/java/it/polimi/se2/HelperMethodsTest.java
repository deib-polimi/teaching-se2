package it.polimi.se2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HelperMethodsTest {

	@Test
	public void HelloTest() {
		HelperMethods h = new HelperMethods();
		String ans = h.hello("affo");
		assertEquals(ans, "Hello affo!");
	}

	@Test
	public void HiTest() {
		HelperMethods h = new HelperMethods();
		String ans = h.hi("affo");
		assertEquals(ans, "Hi affo!");
	}
}
