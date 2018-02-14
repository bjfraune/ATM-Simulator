import java.util.Scanner;


public class ATM {
	public static void main(int args, String[] argv){
		start();
	}

	private static void start() {
		int accNum; 
		do{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to super cool ATM!\nPlease enter your account number:\n");
		Bank.validate(scanner.nextInt());
		
		
		
		}while(accNum != -1);
		
	}
}
