import java.util.Scanner;


public class ATM {
	public static void main(String[] args){
		Bank.initializeBank();
		start();
	}

	@SuppressWarnings("resource")
	private static void start() {
		int accNum; 
		do{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to super cool ATM!\nPlease enter your account number (-1 to exit):\n");
		Bank.validate(accNum = scanner.nextInt());
		
		}while(accNum != -1);
		
	}
}
