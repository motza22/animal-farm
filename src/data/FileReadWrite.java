package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import src.main.java.org.json.JSONArray;

public abstract class FileReadWrite {
	public static final JSONArray load(String aPath) {
		StringBuilder data = new StringBuilder("");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(aPath));
			String row;
			while ((row = reader.readLine()) != null) {
				data.append(row);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			data.append("[]");
			System.out.println("Warning: File not found.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new JSONArray(data.toString());
	}

	public static final void save(String aPath, JSONArray aData) {
		try {
			FileWriter writer = new FileWriter(aPath);
			writer.append(aData.toString());
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
