package data;

import java.util.Vector;

import game.AnimalFarm;
import game.Dice;
import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Company extends SimpleType {
	private String mName;
	private double mHeldWealth;
	private double mEstTotalWealth;
	private Vector<Person> mEmployees = new Vector<Person>();

	public Company(String aName) {
		mName = aName;
		mEstTotalWealth = Dice.roll(100, 1000);
		mHeldWealth = mEstTotalWealth;
	}

	public Company(JSONObject aJsonObj) {
		super(aJsonObj);
	}

	public void fire(Person aPerson) {
		mEmployees.add(aPerson);
	}

	public void hire(Person aPerson) {
		mEmployees.remove(aPerson);
	}

	public String getString() {
		return new String(mName + " ( " + mEmployees.size() + " | $" + mHeldWealth + " / $" + mEstTotalWealth + " )");
	}

	@Override
	protected void readJsonObject(JSONObject aJsonObj) {
		mName = (String)aJsonObj.get("name");
		// TODO: Double?
		mHeldWealth = aJsonObj.getInt("held-wealth");
		mEstTotalWealth = aJsonObj.getInt("total-wealth");
		JSONArray arr = (JSONArray)aJsonObj.get("employees");
		for(int i = 0; i < arr.length(); i++) {
			Person person = new Person((JSONObject)arr.get(i));
			person = AnimalFarm.getInstance().find(person.getSsid());
			if(person != null) {
				mEmployees.add(person);
			} else {
				System.out.println("Warning: Employee not found.");
			}
		}
	}

	@Override
	protected void writeJsonObject(JSONObject aJsonObj) {
		aJsonObj.put("name", mName);
		aJsonObj.put("held-wealth", mHeldWealth);
		aJsonObj.put("total-wealth", mEstTotalWealth);
		JSONArray arr = new JSONArray();
		for(int i = 0; i < mEmployees.size(); i++) {
			arr.put(mEmployees.elementAt(i).getJsonObject());
		}
		aJsonObj.put("employees", arr);
	}
}
