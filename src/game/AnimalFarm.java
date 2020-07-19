package game;

import data.Date;
import data.Person;
import data.Population;
import display.ConsoleManager;

public class AnimalFarm {
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);

	public AnimalFarm() {
		Date.getInstance().load();
		Population.getInstance().tryLoad();
		sConsoleManager.print("Found " + Population.getInstance().size() + " People.");
	}

	public void play() {
		while(Population.getInstance().size() > 0) {
			sConsoleManager.print("Date: " + Date.getInstance().getJsonString());
			int count = 0;
			for(int i = Population.getInstance().size() - 1; i >= 0; i--) {
				Person person = Population.getInstance().personAt(i);
				sConsoleManager.print("Person " + ++count + ": " + person.getJsonString());
				int wealthOffset = person.mSalary - person.mExpenditure;
				// TODO: DO NOT DESTROY WEALTH!
				person.mWealth += wealthOffset;
				if(person.mWealth < 0) {
					Population.getInstance().remove(person);
					sConsoleManager.print("Died.");
				}
			}
			Date.getInstance().increment();
			save();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sConsoleManager.print("Everyone is dead.");
	}

	private void save() {
		Date.getInstance().save();
		Population.getInstance().save();
	}

	public static void main(String [] args) {
		sConsoleManager.print("Load.");
		AnimalFarm animalFarm = new AnimalFarm();
		animalFarm.play();
		sConsoleManager.print("Exit.");
	}
}
