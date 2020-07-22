package data;

import game.Dice;
import src.main.java.org.json.JSONObject;

public class Person extends SimpleType {
	private String mName;
	private int mSalary;
	private int mSsid;
	private int mExpenditure;
	private double mWealth;
	private double mCompanyStock;

	public Person(String aName) {
		mName = aName;
		mSsid = Dice.roll(1000);
		mSalary = Dice.roll(10, 20);
		mExpenditure = Dice.roll(20, 30);
		mWealth = Dice.roll(100);
		mCompanyStock = 0;
	}

	public Person(JSONObject aJsonObj) {
		super(aJsonObj);
	}

	public int getSsid() {
		return mSsid;
	}

	public String getString() {
		return new String(mName + " ( $" + mSalary + " | $" + mExpenditure + " | $" + mWealth + " | $" + mCompanyStock + " )");
	}

	@Override
	protected void readJsonObject(JSONObject aJsonObj) {
		mName = aJsonObj.getString("name");
		mSsid = aJsonObj.getInt("ssid");
		mSalary = aJsonObj.getInt("salary");
		mExpenditure = aJsonObj.getInt("expenditure");
		// TODO: Double?
		mWealth = aJsonObj.getInt("wealth");
		mCompanyStock = aJsonObj.getInt("stock");
	}

	@Override
	protected void writeJsonObject(JSONObject aJsonObj) {
		aJsonObj.put("name", mName);
		aJsonObj.put("ssid", mSsid);
		aJsonObj.put("salary", mSalary);
		aJsonObj.put("expenditure", mExpenditure);
		aJsonObj.put("wealth", mWealth);
		aJsonObj.put("stock", mCompanyStock);
	}
}

