package game;

import java.util.Vector;

import data.FileReadWrite;
import data.Person;
import display.ConsoleManager;
import src.main.java.org.json.JSONArray;

public class AnimalFarm {
	private static final String sSavePath = "C:/Users/Zach/java_workspace/Animal Farm/save/people.txt";
	private static ConsoleManager sConsoleManager = new ConsoleManager(100, 300, 400);
	private Vector<Person> mPeople = new Vector<Person>();

	public AnimalFarm() {
		mPeople.addElement(new Person());
		sConsoleManager.print("Person Created: " + mPeople.elementAt(0).getJsonString());
		save();
	}

	public void play() {
		while(mPeople.size() > 0) {
			for(int i = 0; i < mPeople.size(); i++ ) {
				sConsoleManager.print("Person Killed: " + mPeople.elementAt(0).getJsonString());
				mPeople.removeElementAt(0);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void save() {
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < mPeople.size(); i++) {
			jsonArray.put(mPeople.elementAt(i).getJsonObject());
		}
		FileReadWrite.Save(sSavePath, jsonArray);
	}

	public static void main(String [] args) {
		sConsoleManager.print("Load.");
		AnimalFarm animalFarm = new AnimalFarm();
		animalFarm.play();
		sConsoleManager.print("Exit.");
	}
}
