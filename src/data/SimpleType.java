package data;

import src.main.java.org.json.JSONObject;

public abstract class SimpleType {
	public SimpleType() {}

	public SimpleType(JSONObject aJsonObj) {
		readJsonObject(aJsonObj);
	}

	public JSONObject getJsonObject() {
		JSONObject obj = new JSONObject();
		writeJsonObject(obj);
		return obj;
	}

	public String getJsonString() {
		JSONObject obj = new JSONObject();
		writeJsonObject(obj);
		return obj.toString();
	}

	protected abstract void readJsonObject(JSONObject aJsonObj);
	protected abstract void writeJsonObject(JSONObject aJsonObj);
}
