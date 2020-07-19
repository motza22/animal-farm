package data;

import game.Dice;
import src.main.java.org.json.JSONObject;

public class Person extends SimpleType {
	String mName;
	public int mSalary;
	public int mExpenditure;
	public double mWealth;

	public Person(String aName) {
		mName = aName;
		mSalary = Dice.roll(10, 20);
		mExpenditure = Dice.roll(20, 30);
		mWealth = Dice.roll(100);
	}

	public Person(JSONObject aJsonObj) {
		super(aJsonObj);
	}

	@Override
	public String getString() {
		return new String(mName + " | $" + mSalary + " | $" + mExpenditure + " | $" + mWealth);
	}

	@Override
	protected void readJsonObject(JSONObject aJsonObj) {
		mName = (String)aJsonObj.get("name");
		mSalary = (int)aJsonObj.get("salary");
		mExpenditure = (int)aJsonObj.get("expenditure");
		mWealth = (int)aJsonObj.get("wealth");
	}

	@Override
	protected void writeJsonObject(JSONObject aJsonObj) {
		aJsonObj.put("name", mName);
		aJsonObj.put("salary", mSalary);
		aJsonObj.put("expenditure", mExpenditure);
		aJsonObj.put("wealth", mWealth);
	}
}

