import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// startup atm
		start();
	}

	public static void start() {
		//setup bank
		Bank b1 = new Bank();
		b1.createAccount(1234, 6789, 80);
		b1.createAccount(6789, 4321, 60);

		try (Scanner input = new Scanner(System.in)) {
			String entry = "";
			while (!entry.equals("exit")) {
				System.out.println("Welcome to the ATM.");
				System.out.print("To begin, please enter account number: "); // insert
				entry = input.nextLine();
				if(entry.equals("exit")){
					break;
				}
				int num = Integer.parseInt(entry);
				Account customer = b1.validate(num);
				if (customer == null) {
					System.out.println("Invalid account number.");
				} else {
					System.out.print("Please enter your pin number: ");
					entry = input.nextLine();
					if (!customer.validate(Integer.parseInt(entry))) {
						System.out.println("Invalid pin entered.");
					} else {
						System.out
								.println("0=Quit, 1=Check Balance, 2=Deposit, 3=Withdrawl");
						while (!entry.equals("0")) {
							System.out.print("\nWhat would you like to do? ");
							entry = input.nextLine();
							if (entry.equals("0")) {
								System.out.println("Goodbye.");
								break;
							} else if (entry.equals("1")) {
								System.out.print("Your current balance is: $" + customer.getBalance());
							} else if (entry.equals("2")) {
								System.out.println("Enter how much would you like to deposit: $");
								entry = input.nextLine();
								if(customer.deposit(Double.parseDouble(entry))){
									System.out.print("Your new balance is: $" + customer.getBalance());
								} else {
									System.out.println("Invalid deposit amount.");
								}
							} else if (entry.equals("3")) {
								System.out.println("Enter how much would you like to withdrawl: $");
								entry = input.nextLine();
								if(customer.withdrawl(Double.parseDouble(entry))){
									System.out.print("Your new balance is: $" + customer.getBalance());									
								} else {
									System.out.println("Insufficient funds.");
								}

							} else {
								System.out.println("Invalid entry, please try again.");
							}
						}
					}
				}
			}
		}
	}
}
