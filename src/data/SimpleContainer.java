package data;

import src.main.java.org.json.JSONArray;

public abstract class SimpleContainer {
	private final String mSavePath;

	public SimpleContainer(final String aSavePath) {
		mSavePath = aSavePath;
	}

	public void load() {
		JSONArray jsonArray = FileReadWrite.load(mSavePath);
		readJsonArray(jsonArray);
	}

	public void save() {
		JSONArray jsonArray = new JSONArray();
		writeJsonArray(jsonArray);
		FileReadWrite.save(mSavePath, jsonArray);
	}

	public abstract String getString();
	protected abstract void readJsonArray(JSONArray aJsonArr);
	protected abstract void writeJsonArray(JSONArray aJsonArr);
}
