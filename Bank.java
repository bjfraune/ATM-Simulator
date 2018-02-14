import java.util.Scanner;



public class Bank {

	static Account[] bankAcc = new Account[10];

	public static void initializeBank(){

		bankAcc[0] = new Account(1234, 80, 6789);
		bankAcc[1] = new Account(6789, 60, 4321);

	}
	/**
	 * @param nextInt is the account number from the customer
	 * We check the pin within the bank and if the pin passes 
	 * the account owner can withdraw, deposit, check account 
	 * balance, and exit from within the method
	 */

	public static boolean validatePassed(int nextInt) {
		boolean foundAcc = false;
		for(int i =0; i< 10 && foundAcc == false; ++i){
			if(bankAcc[i] != null && bankAcc[i].getAccNum() == nextInt){
				foundAcc = true;
				// Acc found, now enter pin
				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);
				System.out.println("Enter pin:");
				if(bankAcc[i].validatePin(in.nextInt())){
					// pin true; can now withdraw etc
					while(true){
						int selection;
						do{
							System.out.println("Enter 1 to withdraw, 2 to deposit, 3 to check balance, 4 to exit");
							selection = in.nextInt();
						}while(selection>4 || selection <1);

						if(selection == 1){
							System.out.println("Amount to withdraw:");
							if(bankAcc[i].withdraw(in.nextInt()))
								System.out.println("Withdraw successful");

							else
								System.out.println("Withdraw failed");
						}
						else if(selection ==2){
							System.out.println("Amount to deposit:");
							if(bankAcc[i].deposit(in.nextInt()))
								System.out.println("Deposit successful");
							else
								System.out.println("Deposit failed");
						}
						else if(selection == 3)
							System.out.println("Account balance: "+ bankAcc[i].getBalance());
						else
							break;
					}
				}
			}

		}
		if(foundAcc == false){
			System.out.println("Invalid account number or pin");
		}
		return foundAcc;
	}
	/**
 * @author bshepard
 *	validate the account number and return boolean
 */
	public static  boolean validate(int nextInt) {
		if(nextInt <0 || nextInt >9999) return false;
		for(int i =0; i< 10; ++i){
			if(bankAcc[i] != null && bankAcc[i].getAccNum() == nextInt)
				return true;
		}
		return false;
	
	}
}