package data;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Date extends SimpleContainer {
	private static Date sDate = null;
	int mDay;
	int mMonthish;
	int mYear;

	public static Date getInstance() {
		if(sDate == null) {
			sDate = new Date();
		}
		return sDate;
	}

	private Date() {
		super("C:/Users/Zach/java_workspace/Animal Farm/save/date.txt");
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
	protected void readJsonArray(JSONArray aJsonArr) {
		if(aJsonArr.length() > 0) {
			JSONObject obj = (JSONObject)aJsonArr.get(0);
			mDay = (int)obj.get("day");
			if(((String)obj.get("monthish")).equals("Mudstorm")) {
				mMonthish = 1;
			} else if(((String)obj.get("monthish")).equals("Hellish")) {
				mMonthish = 2;
			} else if(((String)obj.get("monthish")).equals("Depressive")) {
				mMonthish = 3;
			} else if(((String)obj.get("monthish")).equals("Cold")) {
				mMonthish = 4;
			} else {
				mMonthish = 1;
			}
			mYear = (int)obj.get("year");
		}
	}

	@Override
	protected void writeJsonArray(JSONArray aJsonArr) {
		JSONObject obj = new JSONObject();
		obj.put("day", mDay);
		if(mMonthish == 1) {
			obj.put("monthish", new String("Mudstorm"));
		} else if(mMonthish == 2) {
			obj.put("monthish", new String("Hellish"));
		} else if(mMonthish == 3) {
			obj.put("monthish", new String("Depressive"));
		} else if(mMonthish == 4) {
			obj.put("monthish", new String("Cold"));
		} else {
			obj.put("monthish", new String("Mudstorm"));
		}
		obj.put("year", mYear);
		aJsonArr.put(obj);
	}
}
