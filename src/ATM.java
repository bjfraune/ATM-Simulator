import java.util.Scanner;

public class ATM {

	Bank bank;
	CardReader cardReader;
	ATMprinter printer;
	Scanner input;
	int cashAmount;

	public ATM(Bank bank, int initialCashValue) {
		if(bank == null || cardReader == null || printer == null || initialCashValue < 0) {
			throw new IllegalArgumentException("Invalid ATM argument(s)");
		}
		this.bank = bank;
		this.cardReader = new CardReader();
		this.printer = new ATMprinter();
		this.cashAmount = initialCashValue;
		
		input = new Scanner(System.in);
		
		start();
	}


	public void start() {
		//setup bank per lab4 pdf

		@SuppressWarnings("resource")
//		Scanner input = new Scanner(System.in);
		String entry= "";

		while (!entry.equals("exit")) {	// 
			try {	
				System.out.println("Welcome to the ATM.\nTo begin, please enter account number: "); 
				entry = input.nextLine();
				if(entry.equals("exit"))
					break;
				int accountNum =Integer.parseInt(entry);					
				System.out.print("Please enter your pin number: ");
				int pinEntered =  Integer.parseInt(input.nextLine());
				boolean custExists = Bank.validate(accountNum, pinEntered);
				if (!custExists) 
					System.out.println("Invalid account number or pin."); 
				else {
					Account customer = Bank.getAcc(accountNum);					
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
			catch(NumberFormatException e) { 
				System.out.println("ERROR! INVALID:" +e.getMessage());	
			}
		}
	}
}
