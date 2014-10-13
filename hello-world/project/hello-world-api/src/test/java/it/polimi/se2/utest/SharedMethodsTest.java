package it.polimi.se2.utest;

import static org.junit.Assert.*;
import it.polimi.se2.SharedMethods;

import org.junit.Test;

public class SharedMethodsTest {

	@Test
	public void testHelloWolrd() {
		assertEquals(SharedMethods.printHello(), "Hello World!");
	}

}
