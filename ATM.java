import java.util.Scanner;


/**
 * @author bshepard
 * Initialize the accounts per lab4 pdf and start the ATM
 */
public class ATM {
	public static void main(String[] args){
		Bank.initializeBank();
		start();
	}

	@SuppressWarnings("resource")
	private static void start() {
		int accNum; 
		// Keep the ATM running until someone enters -1 to shut down the program
		do{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome to super cool ATM!\nPlease enter your account number (-1 to exit):\n");
			if(Bank.validate(accNum = scanner.nextInt())){
				Bank.validatePassed(accNum);
			}

		}while(accNum != -1);

	}
}