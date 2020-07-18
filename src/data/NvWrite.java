package data;

import src.main.java.org.json.JSONObject;

public abstract class NvWrite {
	NvWrite() {}

	public String getJsonString() {
		JSONObject obj = new JSONObject();
		populateJson(obj);
		return obj.toString();
	}

	protected abstract void populateJson(JSONObject aJsonObj);
}
