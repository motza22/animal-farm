package game;

import java.util.Random;

public abstract class Dice {
	private static Random sRand = new Random();

	public static int roll(int aHigh)  {
		return sRand.nextInt(aHigh);
	}

	public static int roll(int aLow, int aHigh)  {
		return (sRand.nextInt(aHigh - aLow + 1) + aLow);
	}
}
