package game;

import java.util.Vector;

import data.Date;
import data.Person;
import data.Population;
import display.ConsoleManager;

public class AnimalFarm {
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);
	private Vector<Person> mPeople;
	private Date mDate;

	public AnimalFarm() {
		mDate = new Date();
		mPeople = Population.getInstance().tryLoad();
		sConsoleManager.print("Found " + mPeople.size() + " People.");
	}

	public void play() {
		while(mPeople.size() > 0) {
			sConsoleManager.print("New Day: " + mDate.getJsonString());
			int count = 0;
			for(int i = mPeople.size() - 1; i >= 0; i-- ) {
				Person person = mPeople.elementAt(i);
				sConsoleManager.print("Person " + ++count + ": " + person.getJsonString());
				int wealthOffset = person.mSalary - person.mExpenditure;
				// TODO: DO NOT DESTROY WEALTH!
				person.mWealth += wealthOffset;
				if(person.mWealth < 0) {
					mPeople.remove(person);
					sConsoleManager.print("Died.");
				}
			}
			mDate.increment();
			Population.getInstance().save();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sConsoleManager.print("Everyone is dead.");
	}

	public static void main(String [] args) {
		sConsoleManager.print("Load.");
		AnimalFarm animalFarm = new AnimalFarm();
		animalFarm.play();
		sConsoleManager.print("Exit.");
	}
}
