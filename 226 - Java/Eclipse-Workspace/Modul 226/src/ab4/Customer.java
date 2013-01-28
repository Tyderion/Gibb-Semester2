package ab4;

import java.util.UUID;

public class Customer {
	private String name;
	private String firstName;
	private UUID customer_number;
	
	
	public Customer(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		customer_number = UUID.randomUUID();
	}
	
}
