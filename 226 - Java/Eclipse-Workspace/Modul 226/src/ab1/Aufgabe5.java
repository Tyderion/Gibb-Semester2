package ab1;

import utils.Outputter;
import ab4.Account;

public class Aufgabe5 {

	public static String buchAufgabe1() {
		return "Ungültig sind: $Test, _abc, 2test, #hallo, te?st, const\nGültig sind: Hallo_Welt, Girokonto";
	}

	public static String buchAufgabe2() {
		return "Ohne Cast kann man einen Long keinem Int zuweisen.";
	}

	public static String buchAufgabe3() {
		return "1. Zeile\n2. Zeile\n3. Zeile.";
	}

	public static String buchAufgabe4() {
		return "Januar hat " + buchAufgabe4(31);
	}

	public static String buchAufgabe4(int number_of_days) {
		int seconds = number_of_days * 24 * 3600;
		return seconds + " Sekunden";
	}

	public static String buchAufgabe5() {
		return "5000 Fr. zu 7.5% Zins sind nach einem Jahr "
				+ buchAufgabe5(7.5, 5000) + " Fr.";
	}

	public static double buchAufgabe5(double zins, int amount) {
		Account t = new Account(amount, zins, null);
		t.yieldInterest(365);
		return t.getSaldo();
	}

	public static String buchAufgabe6() {
		int a = 1;
		int b = 7;
		StringBuilder str = new StringBuilder("Teilaufgabe\t");
		str.append("Ausdruck\t\tWert\t\tVariable a\t\tVariable b\n");
		str.append("a\t\ta++ \t\t\t1==" + a++ + "\t\t2==" + a + "\t\t\t7=="
				+ b + "\n");
		a = 1;
		b = 7;
		str.append("b\t\ta-- \t\t\t1==" + a-- + "\t\t0==" + a + "\t\t\t7=="
				+ b + "\n");
		a = 1;
		b = 7;
		// Hier Fehler (a++ == a bei auswertung)
		str.append("c\t\ta++ +b\t\t\t8==" + (a++ + b) + "\t\t2==" + a
				+ "\t\t\t7==" + b + "\n");
		a = 1;
		b = 7;
		str.append("d\t\tb = a++\t\t\t1==" + (b = a++) + "\t\t2==" + a
				+ "\t\t\t1==" + b + "\n");
		a = 1;
		b = 7;
		str.append("e\t\ta = b++\t\t\t7==" + (a = b++) + "\t\t7==" + a
				+ "\t\t\t8==" + b + "\n");
		a = 1;
		b = 7;
		// NIE SOWAS MACHEN (-1 -6)
		str.append("f\t\t-(a--)-(--b)\t\t-7==" + (-(a--) - (--b)) + "\t\t0=="
				+ a + "\t\t\t6==" + b + "\n");
		a = 1;
		b = 7;
		// NIE SOWAS MACHEN xD (1 + 3 + 3 = 7) 
		//Hier auch fehler (bei '++a' hat a schon wert 2, hat also den Wert 3)
		str.append("g\t\ta++ + ++a + a++\t\t7==" + (a++ + ++a + a++)
				+ "\t\t4==" + a + "\t\t\t7==" + b + "\n");
		
		str.append("Legende: Zahl==Zahl <-> (Von Hand Berechnet)==(von Java berechnet)");
		return str.toString();
	}

	public static void main(String[] args) {
		Outputter.aufgabe("1 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe1());
		Outputter.aufgabe("2 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe2());
		Outputter.aufgabe("3 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe3());
		Outputter.aufgabe("4 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe4());
		Outputter.aufgabe("5 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe5());
		Outputter.aufgabe("6 Buch Kapitel 2.5", 0);
		System.out.println(buchAufgabe6());
	}
}
