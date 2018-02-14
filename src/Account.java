public class Account {

	private int pin, enteredPin;
	private double balance;

	public Account(int pin, double balance) {
		this.pin = pin;
		if (balance >= 0) {
			this.balance = balance;
		}
	}

	public double getBalance() {
		if (pin != enteredPin) {
			throw new IllegalStateException("Cannot check balance without correct pin.");
		}
		return balance;
	}

	public boolean deposit(double money) {
		if (pin != enteredPin) {
			throw new IllegalStateException("Cannot deposit without correct pin.");
		}
		if (money <= 0) {
			return false;
		}
		balance += money;
		return true;
	}

	public boolean withdrawl(double money) {
		if (pin != enteredPin) {
			throw new IllegalStateException("Cannot deposit without correct pin.");
		}
		if (balance-money <= 0) {
			return false;
		}
		balance -= money;
		return true;
	}

	public boolean validate(int enteredPin) {
		this.enteredPin = enteredPin;
		return pin == enteredPin ? true : false;
	}
}