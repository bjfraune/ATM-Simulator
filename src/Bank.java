import java.util.HashMap;

public class Bank {

	private HashMap<Integer, Account> Account;
	/**All the accounts are stored with in the bank via HashMap.*/
	 
	public Bank() {
		Account = new HashMap<Integer, Account>();
	}
	/**
	 * @param accountNumber
	 * @param pin
	 * @param balance
	 * @return null if account number is already in use, else it returns a newly made account specified by parameters above
	 */
	public Integer createAccount(int accountNumber, int pin, double balance) {
		if (Account.containsKey(accountNumber)) return null;	// Special case: account already exits. Can't have duplicate accounts
		Account.put(accountNumber, new Account(pin, balance));
		return accountNumber;
	}
	/**does the account exist?
	 * @param accountNumber
	 * @return null if the account doesn't exist
	 */
	public Account validate(Integer accountNumber) {
		return Account.get(accountNumber);
	}
}
