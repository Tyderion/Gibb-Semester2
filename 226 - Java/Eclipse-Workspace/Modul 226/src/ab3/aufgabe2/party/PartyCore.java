package ab3.aufgabe2.party;

public class PartyCore {
	private static int nbOfGuests = 0;
	
	public static void setNbOfGuests(int n) {
		if (n>0){
			nbOfGuests = n;
		}
			
	}
	public static int cheers() {
		return nbOfGuests * (nbOfGuests-1)/2;
	}
}
