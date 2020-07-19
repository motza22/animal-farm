package data;

import src.main.java.org.json.JSONArray;

public abstract class SimpleContainer<T> {
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

	public abstract void add(T aObject);
	public abstract T get(int aIdx);
	public abstract void remove(T aObject);
	public abstract int size();
	protected abstract void readJsonArray(JSONArray aJsonArr);
	protected abstract void writeJsonArray(JSONArray aJsonArr);
}
