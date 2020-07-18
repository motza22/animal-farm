package data;

import src.main.java.org.json.JSONObject;

public class Person extends NvWrite {
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

	@Override
	protected void populateJson(JSONObject aJsonObj) {
		aJsonObj.put("name", mName);
		aJsonObj.put("id", mId);
		aJsonObj.put("salary", mSalary);
		aJsonObj.put("wealth", mWealth);
	}
}
