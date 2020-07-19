package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Population extends SimpleContainer<Person> {
	private Vector<Person> mPeople = new Vector<Person>();

	public Population(final String aSavePath) {
		super(aSavePath);
	}

	@Override
	public void add(Person aPerson) {
		mPeople.addElement(aPerson);
	}

	@Override
	public Person get(int aIdx) {
		return mPeople.elementAt(aIdx);
	}

	@Override
	public void remove(Person aPerson) {
		mPeople.remove(aPerson);
	}

	@Override
	public int size() {
		return mPeople.size();
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
