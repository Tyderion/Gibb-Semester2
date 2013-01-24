package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	public static String getLine() {
		String str = null;
		BufferedReader d = new BufferedReader(new InputStreamReader(System.in));

		// String einlesen
		try
		{
			str = d.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return str;
	}
	
	public static Double getDouble(){
		return (Double)get_as("double");
	}
	
	public static int getInt(){
		return (Integer)get_as("integer");
	}
	public static int getInt(String what){
		System.out.println(what);
		return getInt();
	}
	
	
	public static Object get_as(String type) {//throws IllegalArgumentException {
		Object result = null;
		switch(type) {
		case "int":
		case "integer":
		case "Integer":
			while (result == null) {
				try {
					result = Integer.parseInt(getLine());
				} catch (NumberFormatException e) {
					System.out.println("This is no parsable number (Integer). Please try again.");
				}
			}
			
			return result;
		case "dbl":
		case "double":
		case "Double":
			while (result == null) {
				try {
					result = Double.parseDouble(getLine());
				} catch (NumberFormatException e) {
					System.out.println("This is no parsable number (Double). Please try again.");
				}
			}
			return result;
		case "float":
		case "Float":
			while (result == null) {
				try {
					result = Float.parseFloat(getLine());
				} catch (NumberFormatException e) {
					System.out.println("This is no parsable number (Float). Please try again.");
				}
			}
			
			return result;
		case "str":
		case "string":
		case "String":
			return getLine();
		default:
			//throw new IllegalArgumentException(str+" does not correspond to a type or is not programmed to be.");
			System.out.println((type+" does not correspond to a type or is not programmed to be."));
			return null;
		}
		
		
	}
}
