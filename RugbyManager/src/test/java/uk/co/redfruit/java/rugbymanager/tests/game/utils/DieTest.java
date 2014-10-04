package uk.co.redfruit.java.rugbymanager.tests.game.utils;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DieTest {

	@Test
	public void testDie() {
		int result = Die.roll();
		assertTrue(!(result > 19));
		assertTrue(result >= 1);
		System.out.println("Die roll is: " + result);
		result = Die.roll(50);
		assertTrue(!(result > 49));
		assertTrue(result >= 1);
		System.out.println("Die roll is: " + result);
		result = Die.roll(6);
		assertTrue(!(result > 49));
		assertTrue(result >= 1);
		System.out.println("Die roll is: " + result);
	}

}
