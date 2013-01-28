package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader {
	
	public static String getLine() {
		String str = null;
		BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
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
	public static long getLong(){
		return (Long)get_as("long");
	}
	public static int getInt(String what){
		System.out.println(what);
		return getInt();
	}

	
	public static String parseError(String type) {
		return "This is no parsable number of type "+type+". Please try again.";
	}
	
	
	public static Object get_as(String type) throws IllegalArgumentException {
		Object result = null;
		switch(type) {
		case "int":
		case "integer":
		case "Integer":
			while (result == null) {
				try {
					result = Integer.parseInt(getLine());
				} catch (NumberFormatException e) {
					System.out.println(InputReader.parseError("Integer"));
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
					System.out.println(InputReader.parseError("Double"));
				}
			}
			return result;
		case "float":
		case "Float":
			while (result == null) {
				try {
					result = Float.parseFloat(getLine());
				} catch (NumberFormatException e) {
					System.out.println(InputReader.parseError("Float"));
				}
			}
			
			return result;
		case "long":
		case "Long":
			while (result == null) {
				try {
					result = Long.parseLong(getLine());
				} catch (NumberFormatException e) {
					System.out.println(InputReader.parseError("Long"));
				}
			}
			
			return result;
		case "str":
		case "string":
		case "String":
			return getLine();
		default:
			throw new IllegalArgumentException(type+" does not correspond to a type.");
		}
		
		
	}
}
