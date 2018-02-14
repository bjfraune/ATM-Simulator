
public class Account {
	int accountNumber,accountBalance,pin;
	/**
	 * @param input is the entered pin from the customer
	 * @return whether input is valid for this account
	 */
	public Account(int accNum, int pn){
		accountNumber = accNum;
		accountBalance = 0;
		pin = pn;
	}
	public Account(int accNum, int bal, int pn){
		accountNumber = accNum;
		accountBalance = bal;
		pin = pn;
	}
	public int getAccNum(){
		return accountNumber;
	}
	public boolean validatePin(int input){ 
		if(input == pin)
			return true;
		else
			return false;
	}
	public int getBalance(){
		return accountBalance;
	}
	public boolean withdraw(int amountW){
		if(amountW < 0 || amountW > getBalance())
			return false;
		else{
			accountBalance-= amountW;
			return true;
		}	
	}
	public boolean deposit(int amountD){
		if(amountD < 0)
			return false;
		else{
			accountBalance += amountD;
			return true;
		}
	}
	

}
