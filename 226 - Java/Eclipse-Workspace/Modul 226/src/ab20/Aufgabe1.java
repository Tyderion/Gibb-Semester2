package ab20;

import utils.InputReader;

public class Aufgabe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aufgabe a: "+aufgabe_a());
		System.out.println("Bitte gebe eine Zahl ein: ");
		
		System.out.println("Aufgabe b: "+aufgabe_b(InputReader.getDouble()));
	}
	
	
	
	
	private static String aufgabe_a() {
		return aufgabe_a(8);
	}
	
	
	private static String aufgabe_a(int max) {
		String val="";
		for (int i = 0; i < max; i++) {
			for (int j = 0; j<=i; j++){
				val += "*";
			}
			val += "\n";
		}
		return val;
	}


	private static int aufgabe_b(double what) {
		int power_of_two = 1;
		while (power_of_two <= what) {
			power_of_two *= power_of_two;
		}
		return power_of_two;
	}
}
