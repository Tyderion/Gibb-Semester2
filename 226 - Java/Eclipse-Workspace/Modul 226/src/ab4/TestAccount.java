package ab4;

public class TestAccount {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account a,b,c;
		Customer ca,cb,cc;
		ca = new Customer("Müller", "Franz");
		cb = new Customer("Meier", "Thomas");
		cc = new Customer("Hofstetter", "Erich");
		
		a = new Account(ca);
		a.deposit(20.5);
		System.out.println("Korrekt falls "+a.getSaldo() + " == 20.5");
		a.deposit(20.5);
		System.out.println("Korrekt falls "+a.getSaldo() + " == 41");
		
		b = new Account(cb);
		b.deposit(100);
		b.yieldInterest(365);
		System.out.println("Korrekt falls "+b.getSaldo() + " == 105");
		
		c = new Account(7.2, cc);
		c.deposit(100);
		c.yieldInterest(365);
		System.out.println("Korrekt falls "+c.getSaldo() + " == "+(100+7.2));
		
	}

}
