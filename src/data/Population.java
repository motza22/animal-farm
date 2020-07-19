package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Population extends SimpleContainer {
	private static Population sPopulation = null;
	private Vector<Person> mPeople = new Vector<Person>();

	public static Population getInstance() {
		if(sPopulation == null) {
			sPopulation = new Population();
		}
		return sPopulation;
	}

	private Population() {
		super("C:/Users/Zach/java_workspace/Animal Farm/save/people.txt");
	}

	public Person personAt(int aIdx) {
		return mPeople.elementAt(aIdx);
	}

	public void remove(Person aPerson) {
		mPeople.remove(aPerson);
	}

	public int size() {
		return mPeople.size();
	}

	public void tryLoad() {
		load();
		if(mPeople.isEmpty()) {
			createNew();
		}
	}

	private void createNew() {
		mPeople.addElement(new Person("Bob Allen Ford", 90000, 125000, 250000));
		mPeople.addElement(new Person("Timothy Jones", 60000, 61000, 5000));
		save();
	}

	@Override
	protected void readJsonArray(JSONArray aJsonArr) {
		for(int i = 0; i < aJsonArr.length(); i++) {
			Person person = new Person((JSONObject)aJsonArr.get(i));
			mPeople.add(person);
		}
	}

	@Override
	protected void writeJsonArray(JSONArray aJsonArr) {
		for(int i = 0; i < mPeople.size(); i++) {
			aJsonArr.put(mPeople.elementAt(i).getJsonObject());
		}
	}
}
