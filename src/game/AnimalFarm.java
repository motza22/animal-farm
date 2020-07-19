package game;

import java.util.Random;

import data.Date;
import data.Names;
import data.Person;
import data.Population;
import display.ConsoleManager;

public class AnimalFarm {
	private static Random sRand = new Random();
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);
	private Date mDate = new Date("C:/Users/Zach/java_workspace/Animal Farm/data/save/date.txt");
	private Population mPopulation = new Population("C:/Users/Zach/java_workspace/Animal Farm/data/save/people.txt");
	private Names mNames = new Names("C:/Users/Zach/java_workspace/Animal Farm/data/res/names.txt");

	public AnimalFarm() {
		mDate.load();
		mPopulation.load();
		sConsoleManager.print("Found " + mPopulation.size() + " People.");
		if(mPopulation.size() == 0) {
			reinitialize();
		}
	}

	public void play() {
		while(mPopulation.size() > 0) {
			sConsoleManager.print("Date: " + mDate.getJsonString());
			int count = 0;
			for(int i = mPopulation.size() - 1; i >= 0; i--) {
				Person person = mPopulation.personAt(i);
				sConsoleManager.print("Person " + ++count + ": " + person.getJsonString());
				int wealthOffset = person.mSalary - person.mExpenditure;
				// TODO: DO NOT DESTROY WEALTH!
				person.mWealth += wealthOffset;
				if(person.mWealth < 0) {
					mPopulation.remove(person);
					sConsoleManager.print("Died.");
				}
			}
			mDate.increment();
			save();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sConsoleManager.print("Everyone is dead.");
	}

	private void reinitialize() {
		sConsoleManager.print("Reinitializing.");
		for(int i = 0; i < mNames.size(); i++) {
			mPopulation.addPerson(new Person(mNames.elementAt(i), sRand.nextInt(100000), sRand.nextInt(100000), sRand.nextInt(100000)));
		}
		sConsoleManager.print("Created " + mPopulation.size() + " People.");
	}

	private void save() {
		mDate.save();
		mPopulation.save();
	}

	public static void main(String [] args) {
		sConsoleManager.print("Load.");
		AnimalFarm animalFarm = new AnimalFarm();
		animalFarm.play();
		sConsoleManager.print("Exit.");
	}
}
