package data;

import src.main.java.org.json.JSONObject;

public class Date extends SimpleType {
	int mDay;
	int mMonthish;
	int mYear;

	public Date() {
		mDay = 1;
		mMonthish = 1;
		mYear = 1000;
	}

	public void increment() {
		mDay++;
		if(mDay > 25) {
			mMonthish++;
			if(mMonthish > 4) {
				mYear++;
				mMonthish = 1;
			}
			mDay = 1;
		}
	}

	@Override
	protected void readJsonObject(JSONObject aJsonObj) {
		mDay = (int)aJsonObj.get("day");
		if(((String)aJsonObj.get("monthish")).equals("Mudstorm")) {
			mMonthish = 1;
		} else if(((String)aJsonObj.get("monthish")).equals("Hellish")) {
			mMonthish = 2;
		} else if(((String)aJsonObj.get("monthish")).equals("Depressive")) {
			mMonthish = 3;
		} else if(((String)aJsonObj.get("monthish")).equals("Cold")) {
			mMonthish = 4;
		} else {
			mMonthish = 1;
		}
		mYear = (int)aJsonObj.get("year");
	}

	@Override
	protected void writeJsonObject(JSONObject aJsonObj) {
		aJsonObj.put("day", mDay);
		if(mMonthish == 1) {
			aJsonObj.put("monthish", new String("Mudstorm"));
		} else if(mMonthish == 2) {
			aJsonObj.put("monthish", new String("Hellish"));
		} else if(mMonthish == 3) {
			aJsonObj.put("monthish", new String("Depressive"));
		} else if(mMonthish == 4) {
			aJsonObj.put("monthish", new String("Cold"));
		} else {
			aJsonObj.put("monthish", new String("Mudstorm"));
		}
		aJsonObj.put("year", mYear);
	}
}
