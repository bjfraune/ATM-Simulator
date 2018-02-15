import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		// startup atm
		start();
	}
/** Turns the ATM on
 * @note: We setup the accounts at the begining of start() per the lab4 instructions.
 * @category main while loop---
 * main loop for ATM 
 * all validation for account/ pin, withdraw, deposit, check balance functions happen with this loop
 */
	public static void start() {
		//setup bank per lab4 pdf
		Bank b1 = new Bank();
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String entry= "";
		b1.createAccount(1234, 6789, 80);
		b1.createAccount(6789, 4321, 60);


	
		while (!entry.equals("exit")) {	// 
			try {	
				System.out.println("Welcome to the ATM.\nTo begin, please enter account number: "); 
				entry = input.nextLine();
				if(entry.equals("exit"))
					break;
				Account customer = b1.validate(Integer.parseInt(entry));
				if (customer == null) 
					System.out.println("Invalid account number."); 
				else {
					System.out.print("Please enter your pin number: ");
					entry = input.nextLine();
					if (!customer.validate(Integer.parseInt(entry)))
						System.out.println("Invalid pin entered.");
					else {
						while (!entry.equals("0")) {
							System.out.println("0=Quit, 1=Check Balance, 2=Deposit, 3=Withdrawl");
							entry = input.nextLine();
							if (entry.equals("0")) {
								System.out.println("Goodbye.");
								break;
							} 
							else if (entry.equals("1"))
								System.out.println("Your current balance is: $" + customer.getBalance()); 
							else if (entry.equals("2")) {
								System.out.println("Enter how much would you like to deposit: $");
								entry = input.nextLine();
								if(customer.deposit(Double.parseDouble(entry)))
									System.out.println("Your new balance is: $" + customer.getBalance());
								else 
									System.out.println("Invalid deposit amount.");
							} 
							else if (entry.equals("3")) {
								System.out.println("Enter how much would you like to withdrawl: $");
								entry = input.nextLine();
								if(customer.withdrawl(Double.parseDouble(entry)))
									System.out.println("Your new balance is: $" + customer.getBalance());									
								else 
									System.out.println("Invalid withdraw amount.");
							} 
							else 
								System.out.println("Invalid entry, please try again.");							
						}
					}
				}
			}
			catch(NumberFormatException e) { 
				System.out.println("ERROR! INVALID:" +e.getMessage());	
			}
		}
	}
}