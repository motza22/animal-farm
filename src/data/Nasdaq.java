package data;

import java.util.Vector;

import src.main.java.org.json.JSONArray;
import src.main.java.org.json.JSONObject;

public class Nasdaq extends SimpleContainer<Company> {
	private Vector<Company> mCompanies = new Vector<Company>();

	public Nasdaq(final String aSavePath) {
		super(aSavePath);
	}

	@Override
	public void add(Company aCompany) {
		mCompanies.addElement(aCompany);
	}

	@Override
	public Company get(int aIdx) {
		return mCompanies.elementAt(aIdx);
	}

	@Override
	public void remove(Company aCompany) {
		mCompanies.remove(aCompany);
	}

	@Override
	public int size() {
		return mCompanies.size();
	}

	@Override
	protected void readJsonArray(JSONArray aJsonArr) {
		for(int i = 0; i < aJsonArr.length(); i++) {
			Company company = new Company((JSONObject)aJsonArr.get(i));
			mCompanies.add(company);
		}
	}

	@Override
	protected void writeJsonArray(JSONArray aJsonArr) {
		for(int i = 0; i < mCompanies.size(); i++) {
			aJsonArr.put(mCompanies.elementAt(i).getJsonObject());
		}
	}

}
