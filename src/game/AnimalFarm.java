package game;

import data.Company;
import data.Date;
import data.Names;
import data.Nasdaq;
import data.Person;
import data.Population;
import display.ConsoleManager;

public class AnimalFarm {
	private static AnimalFarm sAnimalFarm = null;
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);
	private Date mDate = new Date("./data/save/date.txt");
	private Population mPopulation = new Population("./data/save/people.txt");
	private Nasdaq mNasdaq = new Nasdaq("./data/save/nasdaq.txt");

	public static AnimalFarm getInstance() {
		if(sAnimalFarm == null) {
			sAnimalFarm = new AnimalFarm();
		}
		return sAnimalFarm;
	}

	private AnimalFarm() {
		mDate.load();
		mPopulation.load();
		mNasdaq.load();
		sConsoleManager.print("Found " + mPopulation.size() + " People.");
		sConsoleManager.print("Found " + mNasdaq.size() + " Companies.");
		if(mPopulation.size() == 0 || mNasdaq.size() == 0) {
			reinitialize();
		}
	}

	public Person find(int aSsid) {
		for(int i = 0; i < mPopulation.size(); i++) {
			if(mPopulation.get(i).getSsid() == aSsid ) {
				return mPopulation.get(i);
			}
		}
		return null;
	}

	public void play() {
		while(mPopulation.size() > 0 && mNasdaq.size() > 0) {
			sConsoleManager.print(new String(""));
			sConsoleManager.print(mDate.getString());
			takeTurn();
			mDate.increment();
			save();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		sConsoleManager.print("Everyone is dead.");
	}

	private void reinitialize() {
		sConsoleManager.print("Reinitializing.");

		Names names = new Names("./data/res/names.txt");
		Names companyNames = new Names("./data/res/company_names.txt");

		for(int i = 0; i < names.size(); i++) {
			mPopulation.add(new Person(names.elementAt(i)));
		}
		sConsoleManager.print("Created " + mPopulation.size() + " People.");

		for(int i = 0; i < companyNames.size(); i++) {
			mNasdaq.add(new Company(companyNames.elementAt(i)));
		}
		sConsoleManager.print("Created " + mNasdaq.size() + " Companies.");

		save();
	}

	private void save() {
		mDate.save();
		mPopulation.save();
		mNasdaq.save();
	}

	private void takeTurn() {
		for(int i = mPopulation.size() - 1; i >= 0; i--) {
			Person person = mPopulation.get(i);
			sConsoleManager.print(person.getString());
			mPopulation.remove(person);
			sConsoleManager.print("Died.");
		}

		for(int i = mNasdaq.size() - 1; i >= 0; i--) {
			Company company = mNasdaq.get(i);
			sConsoleManager.print(company.getString());
			mNasdaq.remove(company);
			sConsoleManager.print("Bankrupt.");
		}
	}

	public static void main(String [] args) {
		sConsoleManager.print("Load.");
		AnimalFarm.getInstance().play();
		sConsoleManager.print("Exit.");
	}
}
