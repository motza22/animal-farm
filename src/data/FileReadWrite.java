package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import src.main.java.org.json.JSONArray;

public abstract class FileReadWrite {
	public static final JSONArray Load(String aPath) {
		StringBuilder data = new StringBuilder("");
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(aPath));
			String row;
			while ((row = csvReader.readLine()) != null) {
				data.append(row);
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONArray(data);
	}

	public static final void Save(String aPath, JSONArray aData) {
		try {
			FileWriter csvWriter = new FileWriter(aPath);
			csvWriter.append(aData.toString());
			csvWriter.flush();
			csvWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
