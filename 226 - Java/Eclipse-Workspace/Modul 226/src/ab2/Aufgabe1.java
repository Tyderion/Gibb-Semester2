package ab2;

import utils.InputReader;
import utils.Outputter;

public class Aufgabe1 {

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
	
	private static int aufgabe_b(double number) {
		int power_of_two = 2;
		int n = 1;
		while (power_of_two <= number) {
			power_of_two *= 2;
			n++;
		}
		return n;
	}
	
	private static int aufgabe_c(int p, int q) {
		if (p < q) {
			int _temp = p;
			p = q;
			q = _temp;
		}
		
		while (q != 0) {
			 int r =  p % q;
			 p = q;
			 q = r;
		}
		return p;
	}
	
	private static String aufgabe_d(int b, int h) {
		StringBuilder result = new StringBuilder();
		int length = b*h;
		for (int i = 1; i<=h;i++){
			for (int j = 0; j<(length-i*b);j++) {
				result.append(" ");
			}
			for (int j = 0; j<i*b; j++) {
				result.append("*");
			}
			result.append("\n");
		}	
		return result.toString();
	}
	
	
	
	private static String aufgabe_e_10(int number) {
		String result = "";
		for (int i = 31; i>=0; i--) {
			result += (number & (1 << i)) == 0 ? "0" : "1";
		}
		return result;
	}
	
	private static int aufgabe_e_12_factorial(int number) {
		int result = 1;
		for (int i = 2; i<= number; i++) {
			result *= i;
		}
		return result;
	}

	private static String aufgabe_e_13() {
		StringBuilder result = new StringBuilder();
		
		for (int i = 1; i<= 10; i++) {
			for (int j = 1; j<= 10; j++) {
				result.append(i*j).append("\t");
			}
			result.append("\n");
		}
		
		return result.toString();
	}
	
	private static String aufgabe_e_15_prime_factors(Long number) {
		StringBuilder result = new StringBuilder();
		int factor = 2;
		while (number  > 1) {
			if (number % factor != 0)
			{
				factor++;
			} else {
				number /= factor;
				if (result.length() > 0) {
					result.append(" * ");
				}
				result.append(factor);
			}
		}
		return result.toString();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 3;
		double c = 3.0;
		byte n = 3;
		float f = 9f;
		
		System.out.println((a&n*n));
//		Outputter.aufgabe("a", 0);
//		System.out.println(aufgabe_a());
//		Outputter.aufgabe("b 2er Potenz", 1);
//		System.out.println(aufgabe_b(InputReader.getDouble()));
//		Outputter.aufgabe("c GGT", 2);
//		System.out.println(aufgabe_c(InputReader.getInt(),InputReader.getInt()));
//		Outputter.aufgabe("d Treppe", 2);
//		System.out.println(aufgabe_d(InputReader.getInt("b"),InputReader.getInt("h")));
//		Outputter.aufgabe("e_10 Binärdarstellung", 1);
//		System.out.println(aufgabe_e_10(InputReader.getInt()));
//		Outputter.aufgabe("e_12 Fakultät", 1);
//		System.out.println(aufgabe_e_12_factorial(InputReader.getInt()));
//		Outputter.aufgabe("e_13 Einmaleins", 0);
//		System.out.println(aufgabe_e_13());
//		Outputter.aufgabe("e_15 Primärfaktoren", 1);
//		System.out.println(aufgabe_e_15_prime_factors(InputReader.getLong()));
	}
	
}
