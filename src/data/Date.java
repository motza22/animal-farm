package data;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Date extends SimpleContainer<Date> {
	private int mDay = 1;
	private int mMonthish = 1;
	private int mYear = 1000;

	public Date(final String aSavePath) {
		super(aSavePath);
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

	public String getString() {
		if(mMonthish == 1) {
			return new String( mYear + "-Mudstorm-" + mDay);
		} else if(mMonthish == 2) {
			return new String( mYear + "-Hellish-" + mDay);
		} else if(mMonthish == 3) {
			return new String( mYear + "-Depressive-" + mDay);
		} else if(mMonthish == 4) {
			return new String( mYear + "-Cold-" + mDay);
		} else {
			return new String( mYear + "-Mudstorm-" + mDay);
		}
	}

	@Override
	public void add(Date aDate) {
	}

	@Override
	public Date get(int aIdx) {
		return this;
	}

	@Override
	public void remove(Date aDate) {
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	protected void readJsonArray(JSONArray aJsonArr) {
		if(aJsonArr.length() > 0) {
			JSONObject obj = (JSONObject)aJsonArr.get(0);
			mDay = obj.getInt("day");
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
			mYear = obj.getInt("year");
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
