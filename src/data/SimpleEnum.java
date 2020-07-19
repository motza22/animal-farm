package data;

import src.main.java.org.json.JSONArray;

public abstract class SimpleEnum<T> {
	private final String mSavePath;

	public SimpleEnum(final String aSavePath) {
		mSavePath = aSavePath;
	}
	public abstract T elementAt(int aIndex);
	public void load() {
		JSONArray jsonArray = FileReadWrite.load(mSavePath);
		readJsonArray(jsonArray);
	}
	public abstract int size();
	protected abstract void readJsonArray(JSONArray aJsonArr);
}
