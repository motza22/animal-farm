package data;

import src.main.java.org.json.JSONObject;

public class Person extends SimpleType {
	String mName;
	public int mSalary;
	public int mExpenditure;
	public double mWealth;

	public Person(String aName, int aSalary, int aExpenditure, double aWealth) {
		mName = aName;
		mSalary = aSalary;
		mExpenditure = aExpenditure;
		mWealth = aWealth;
	}

	public Person(JSONObject aJsonObj) {
		super(aJsonObj);
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

