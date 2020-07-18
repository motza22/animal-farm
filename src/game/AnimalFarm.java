package game;

import display.ConsoleManager;

public class AnimalFarm {
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);

	public AnimalFarm() {
		sConsoleManager.print("Initializing...");
	}

	public void play() {
		for(int i = 0; i < 40; i++) {
			sConsoleManager.print("Run.");

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String [] args) {
		sConsoleManager.print("Loading...");
		AnimalFarm animalFarm = new AnimalFarm();
		animalFarm.play();
		sConsoleManager.print("Exit.");
	}

}
