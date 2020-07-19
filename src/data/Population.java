package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Population extends SimpleContainer {
	private Vector<Person> mPeople = new Vector<Person>();

	public Population(final String aSavePath) {
		super(aSavePath);
	}

	public void addPerson(Person aPerson) {
		mPeople.addElement(aPerson);
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

	@Override
	public String getString() {
		return new String("Population count: " + mPeople.size());
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
