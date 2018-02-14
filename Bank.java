import java.util.Scanner;


public class Bank {
	
	static Account[] bankAcc = new Account[10];
	
	public static void initializeBank(){
	
	bankAcc[0] = new Account(1234, 80, 6789);
	bankAcc[1] = new Account(6789, 60, 4321);
	
	}
	//HashMap<Account> accounts;
	
	public static void validate(int nextInt) {
		// TODO Auto-generated method stub
		boolean foundAcc = false;
		for(int i =0; i< 10 && foundAcc == false; ++i){
			if(bankAcc[i].getAccNum() == nextInt){
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
						do{
						System.out.println("Amount to withdraw:");
						}while(bankAcc[i].withdraw(in.nextInt()));
					}
					
					else if(selection ==2){
						do{
						System.out.println("Amount to deposit:");
						}while(bankAcc[i].deposit(in.nextInt()));
					}
					else if(selection == 3)
						System.out.println("Account balance: "+ bankAcc[i].getBalance());
					else
						break;
					}
				}
			}
			
		}
		if(foundAcc == false)
			System.out.println("Invalid account number or pin");
	}
}
