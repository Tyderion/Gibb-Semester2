package ab3;

import utils.CSVOutputter;
import utils.Outputter;

public class Aufgabe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("new String(\"hello\") == new String(\"hello\")");
		System.out.println(new String("hello") == new String("hello"));
		System.out.println("new String(\"hello\") == \"hello\"");
		System.out.println(new String("hello") == "hello");
		System.out.println("new String(\"hello\").equals(new String(\"hello\"))");
		System.out.println(new String("hello").equals(new String("hello")));
		Outputter.aufgabe("a", 0);
		aufgabe_a();
		Outputter.aufgabe("b", 0);
		aufgabe_b();
		
		
		System.out.println("\nReading saved Things from File and outputting it: ");
		CSVOutputter t  = new CSVOutputter("testfile.csv");
		Double[][] s = t.load();

		for (int i = 0; i< t.titles().length; i++) {
			System.out.print(t.titles()[i]+"\t");
			if (i == 1) System.out.print("\t");
		}
		System.out.print("\n");
		
		for (Double[] line : s) {
			for (int i = 1; i < line.length; i++) {
				if (i > 1) {
					System.out.print("\t");
					System.out.print(String.format("%.8f",line[i]));
				} else {
					System.out.print(line[0].intValue()+"^"+line[1].intValue());
					System.out.print("\t");
				}
				
			}
			System.out.print("\n");
		}
	}
	
	
	public static void aufgabe_b() {
		int max_steps_exponent = 8;
		double[][] results = new double[max_steps_exponent][2];
		for (int i = 1; i<=max_steps_exponent;i++) {
			results[i-1][0] = 4*aufgabe_b_leibniz((int)Math.pow(10,i));
			results[i-1][1] = Math.PI - results[i-1][0];
		}
		CSVOutputter output = new CSVOutputter("testfile.csv");
		output.setTitle("Schritte","Pi","Abweichung");
		for (int i = 0; i<max_steps_exponent; i++) {
			output.addValue((Integer)10,(Integer)i+1,String.format("%.8f",results[i][0]), String.format("%.8f",results[i][1]));
		}
		output.save();
		System.out.println("Schritte\tPi\t\tAbweichung");
		for (int i = 1; i<=max_steps_exponent; i++) {
			System.out.println(String.format("10^%s\t\t%.8f\t%.8f",i,results[i-1][0],results[i-1][1]));
		}
	}
	
	
	public static double aufgabe_b_leibniz(int n) {
		double pi_divided_by_4 = 0;
		for (int i = 0; i<n;i++) {
			pi_divided_by_4 += Math.pow(-1,i)/(2*i+1);
		}
		return pi_divided_by_4;
	}
	
	
	public static void aufgabe_a() {
		double[] noten;
		noten =  new double[(int) (Math.random()*100)];
		for (int i = 0; i<noten.length;i++) {
			noten[i] = ((double)Math.round(10*(Math.random()*5+1)))/10;
		}
		System.out.print("[");
		for (int i = 0; i<noten.length;i++) {
		System.out.print(noten[i]);	
		if (i<noten.length-1) {
			System.out.print(", ");
		}
		}
		System.out.print("]\n");

		aufgabe_a(noten);
	}
	
	
	
	public static void aufgabe_a(double[] array) {
		double max, min, mean;
		max = min = mean = array[0];
		for (int i = 1;i<array.length; i++ ) {
			if (array[i] > max) {max = array[i]; }
			if (array[i] < min) {min = array[i]; }
			mean += array[i];
		}
		mean /= array.length;
		System.out.println("Minimum: "+min+"\t Maximum: "+max+"\t Durchschnitt: "+mean);
	}

}
