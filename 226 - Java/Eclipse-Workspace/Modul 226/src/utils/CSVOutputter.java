package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CSVOutputter {
	private String path, titles;
	private ArrayList<String> list_of_values;
	
	public CSVOutputter(String filepath) {
		path = filepath;
		list_of_values = new ArrayList<String>();
	}
	public void setTitle(Object... values) {
		StringBuilder result = new StringBuilder();
		for (Object o : values) {
			result.append(o.toString()).append(",");
		}
		titles =result.toString().substring(0,result.length()-1);
		System.out.println(titles);
	}
	
	public void addValue(Object... values) {
		StringBuilder result = new StringBuilder();
		for (Object o : values) {
			result.append(o.toString()).append(",");
		}
		list_of_values.add(result.toString().substring(0,result.length()-1));
	}
	
	public boolean save() {
		try 
		 {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			out.write(titles+"\n");
			for (String entry : list_of_values) {
				out.write(entry+"\n");
			}
			out.close();
		 }catch (IOException e) {
			 e.printStackTrace();
			 return false;
		 }
		return true;
	}
	
	
	public String[] titles() {
		return titles.split(",");
	}
	
	public Double[][] load() {
		ArrayList<Double[]> objs_list = new ArrayList<Double[]>();
		try {
			BufferedReader in = new BufferedReader(new FileReader(path));
			titles = in.readLine();
			String str = "";
			while ((str = in.readLine()) != null) {
				String[] values = str.split(",");
				Double[] test = new Double[values.length];
				for (int i = 0; i<test.length; i++) {
					test[i] = Double.parseDouble(values[i]);
				}
				objs_list.add(test);
			}
//			objs_list.add(in.readLine().split(","));
			in.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return objs_list.toArray(new Double[][]{});
	}
}
