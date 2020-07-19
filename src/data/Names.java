package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;

public class Names extends SimpleEnum<String> {
	private Vector<String> mNames = new Vector<String>();

	public Names(final String aSavePath) {
		super(aSavePath);
		load();
	}

	@Override
	public int size() {
		return mNames.size();
	}

	@Override
	public String elementAt(int aIndex) {
		return mNames.elementAt(aIndex);
	}

	@Override
	protected void readJsonArray(JSONArray aJsonArr) {
		for(int i = 0; i < aJsonArr.length(); i++) {
			mNames.add(new String(aJsonArr.getString(i)));
		}
	}
}
