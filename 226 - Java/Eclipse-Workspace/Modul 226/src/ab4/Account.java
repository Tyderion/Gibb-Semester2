package ab4;

public class Account {
	private double balance;
	private double interestRate;
	private Customer owner;
	
	public Account(Customer owner) {
		this(0.0,0.05, owner);
	}
	public Account(double interestRate,Customer owner) {
		this(0.0,interestRate,owner);
	}
	public Account(double initial_balance, double interestRate,Customer owner) {
		this.balance = initial_balance;
		this.interestRate = interestRate;
		this.owner = owner;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void yieldInterest(int days) {
		balance += (balance * interestRate*days/360);
	}
	
	public double getSaldo() {
		return balance;
	}
	
	public Customer getOwner() {
		return owner;
	} 

}
