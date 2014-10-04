package uk.co.redfruit.java.rugbymanager.tests.game.utils;

import java.util.Random;

public class Die {

	//default number of sides is 20
	public static int roll() {
		return roll(20);
	}

	public static int roll(int sides) {
		Random randomIntGenerator = new Random();
		int result = randomIntGenerator.nextInt(sides) + 1;
		return result;
	}
	

}
