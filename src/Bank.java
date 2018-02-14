import java.util.HashMap;

public class Bank {

	private HashMap<Integer, Account> accounts;

	public Bank() {
		accounts = new HashMap<Integer, Account>();
	}

	public Integer createAccount(int accountNumber, int pin, double balance) {
		if (accounts.containsKey(accountNumber)) {
			return null;
		}
		accounts.put(accountNumber, new Account(pin, balance));
		return accountNumber;
	}

	public Account validate(Integer accountNumber) {
		return accounts.get(accountNumber);
	}
}
