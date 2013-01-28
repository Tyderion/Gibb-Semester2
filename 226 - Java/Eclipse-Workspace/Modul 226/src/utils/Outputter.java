package utils;

public class Outputter {
	
	public static void aufgabe(String postfix, int number_of_inputs) {
		String output = "\nAufgabe "+postfix+": ";
		switch (number_of_inputs) {
		case 0:
			break;
		case 1:
			output += "\nBitte geben Sie 1 Zahl ein: ";
			break;
		default: 
			output += "\nBitte geben Sie "+number_of_inputs+" Zahlen ein: ";
			break;
		}
		System.out.println(output);
	}

}
