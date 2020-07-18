package data;

import src.main.java.org.json.JSONObject;

public abstract class SimpleType {
	SimpleType() {}

	public JSONObject getJsonObject() {
		JSONObject obj = new JSONObject();
		populateJson(obj);
		return obj;
	}

	public String getJsonString() {
		JSONObject obj = new JSONObject();
		populateJson(obj);
		return obj.toString();
	}

	protected abstract void loadJson(JSONObject aJsonObj);
	protected abstract void populateJson(JSONObject aJsonObj);
}
