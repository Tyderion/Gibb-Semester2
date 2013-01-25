package ab2;

import utils.InputReader;
import utils.Outputter;

public class Aufgabe2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Outputter.aufgabe("2", 2);
		int a = InputReader.getInt();
		int b = InputReader.getInt();
		
		int[] results = {a+b, a-b, a*b, a/b, a%b};
		for (int i = 1; i<=6; i++) 
		{
			try 
			{
				System.out.println(calc(a, b,i)+" == "+results[i-1]);
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static int calc(int operand1, int operand2, int operand3) throws IllegalArgumentException {
		switch (operand3) {
		case 1:
			return operand1+operand2;
		case 2:
			return operand1-operand2;
		case 3:
			return operand1*operand2;
		case 4:
			return operand1/operand2;
		case 5:
			return operand1%operand2;
		default:
			throw new IllegalArgumentException(operand3+" ist kein möglicher Operator");
		}
	}
	
	

}
