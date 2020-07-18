package data;

import src.main.java.org.json.JSONObject;

public class Person extends SimpleType {
	String mName;
	int mId;
	int mSalary;
	double mWealth;

	public Person() {
		mName = "Bob Allen Ford";
		mId = 1234;
		mSalary = 90000;
		mWealth = 250000;
	}

	public Person(JSONObject aJsonObj) {
		super(aJsonObj);
	}

	@Override
	protected void readJsonObject(JSONObject aJsonObj) {
		mName = (String)aJsonObj.get("name");
		mId = (int)aJsonObj.get("id");
		mSalary = (int)aJsonObj.get("salary");
		mWealth = (int)aJsonObj.get("wealth");
	}

	@Override
	protected void writeJsonObject(JSONObject aJsonObj) {
		aJsonObj.put("name", mName);
		aJsonObj.put("id", mId);
		aJsonObj.put("salary", mSalary);
		aJsonObj.put("wealth", mWealth);
	}
}
