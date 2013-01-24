package utils;

public class InputReader {
	
	public static String getLine() {
		return System.console().readLine();
	}
	
	public static Double getDouble(){
		return (Double)get_as("double");
	}
	
	public static Object get_as(String str) {//throws IllegalArgumentException {
		switch(str) {
		case "int":
		case "integer":
		case "Integer":
			return Integer.parseInt(getLine());
		case "dbl":
		case "double": 
		case "Double": 
			return Double.parseDouble(getLine());
		case "float":
		case "Float":
			return Float.parseFloat(getLine());
		case "str":
		case "string":
		case "String":
			return getLine();
		default:
			//throw new IllegalArgumentException(str+" does not correspond to a type or is not programmed to be.");
			System.out.println((str+" does not correspond to a type or is not programmed to be."));
			return null;
		}
		
		
	}
}
