package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Population {
	private static Population sPopulation = null;
	private static final String sSavePath = "C:/Users/Zach/java_workspace/Animal Farm/save/people.txt";
	private Vector<Person> mPeople = new Vector<Person>();

	public static Population getInstance() {
		if(sPopulation == null) {
			sPopulation = new Population();
		}
		return sPopulation;
	}

	private Population() {}

	public Vector<Person> tryLoad() {
		load();
		if(mPeople.isEmpty()) {
			createNew();
		}
		return mPeople;
	}

	public void save() {
		JSONArray jsonArray = new JSONArray();
		for(int i = 0; i < mPeople.size(); i++) {
			jsonArray.put(mPeople.elementAt(i).getJsonObject());
		}
		FileReadWrite.save(sSavePath, jsonArray);
	}

	private void createNew() {
		mPeople.addElement(new Person("Bob Allen Ford", 90000, 125000, 250000));
		mPeople.addElement(new Person("Timothy Jones", 60000, 61000, 5000));
		save();
	}

	private void load() {
		JSONArray jsonArray = FileReadWrite.load(sSavePath);
		for(int i = 0; i < jsonArray.length(); i++) {
			Person person = new Person((JSONObject)jsonArray.get(i));
			mPeople.add(person);
		}
	}
}
