/* 
 * Gabriel Nadler
 * InfW12.2A
 * 25.2.2013
 * Serie F
 */
public class MusterF {
	static void muster(int laenge) {
		for (int i = 0; i < laenge; i++) { // Obere Hälfte: Aufwärts iterieren
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("\\");
			// Anzahl Abstände zwischen / und \ sind laenge-(i+1) * 2
			for (int j = 0; j < (laenge - (i + 1)) * 2; j++) {
				System.out.print(" ");
			}
			System.out.print("/\n");
		}
		for (int i = laenge - 1; i >= 0; i--) { // Untere Hälfte: abwäts
												// iterieren
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			System.out.print("/");
			// Anzahl Abstände zwischen \ und / sind laenge-(i+1)
			for (int j = 0; j < (laenge - (i + 1)) * 2; j++) {
				System.out.print(" ");
			}
			System.out.print("\\\n");
		}

	}
	
	static void muster2(int laenge) {
		for (int i = 0; i < laenge; i++) {
			int j = 0;
			for (; j < i; j++, System.out.print(" "))
				;
			System.out.print("\\");
			j = 0;
			int spaces = (laenge - (i + 1)) * 2;
			for (; j < spaces; j++, System.out.print(" "))
				System.out.print("/\n");
		}
		for (int i = laenge - 1; i >= 0; i--) {
			int j = 0;
			for (; j < i; j++, System.out.print(" "))
				System.out.print("/");
			j = 0;
			int spaces = (laenge - (i + 1)) * 2;
			for (; j < spaces; j++, System.out.print(" "))
				System.out.print("\\\n");
		}

	}

	static void muster_lino(int laenge) {
		int line_length = 2 * laenge;
		for (int i = 0; i < laenge; i++) {
			for (int j = 0; j < line_length; j++) {
				if (j == i)
					System.out.print("\\");
				else if (j == line_length - i - 1) {
					System.out.print("/\n");
					break;
				} else
					System.out.print(" ");
			}
		}
		for (int i = laenge - 1; i >= 0; i--) {
			for (int j = 0; j < line_length; j++) {
				if (j == i)
					System.out.print("/");
				else if (j == line_length - i - 1) {
					System.out.print("\\\n");
					break;
				} else
					System.out.print(" ");
			}
		}
	}



	static void muster_lino_one_inner_loop(int laenge) {
		int line_length = 2 * laenge;
		for (int i = 0; i < laenge * 2; i++) {
			for (int j = 0; j < line_length; j++) {
				if (i < laenge) {
					if (j == i)
						System.out.print("\\");
					else if (j == line_length - i - 1) {
						System.out.print("/\n");
						break;
					} else
						System.out.print(" ");
				} else {
					if (j == i) {
						System.out.print("\\\n");
						break;
					} else if (j == line_length - i - 1)
						System.out.print("/");
					else
						System.out.print(" ");
				}
			}
		}
	}

	public static void main(String[] args) {
		muster(2);
		System.out.println(""); // Oder System.out.print("\n");
		muster_lino_one_inner_loop(2);
	}

}
