import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author Fawzieh Assad Hannah Churchill
 * 
 * 
 *
 */
public class ATMtst1 {

	@Test
	public void test() {
		Bank bank = new Bank();
		bank.initializeBank();
		Account A1 = bank.bankAcc[0];
		Account A2 = bank.bankAcc[1];
		
		//validate the two accounts
		assertTrue(Bank.validate(1234));
		assertTrue(Bank.validate(6789));
		assertFalse(Bank.validate(5896));
		
		//validate the pin and balance
		//assertFalse(bank.validate(A3));
		assertFalse(A1.pin == 4321);
		assertFalse(A2.pin == 6789);
		assertFalse(A1.getBalance() < 0);
		assertFalse(A2.getBalance() == 80);
		
		//validate the withdraw and deposit
		assertTrue(A1.deposit(50));
		assertFalse(A1.withdraw(200));
		assertTrue(A1.withdraw(20));
		assertEquals(110,A1.getBalance());
		
		assertTrue(A2.deposit(100));
		assertEquals(160,A2.getBalance());
		assertFalse(A2.withdraw(200));
		assertEquals(160, A2.getBalance());
		assertTrue(A2.withdraw(160));
		
		assertFalse(A1.deposit(-90));
		assertEquals(110,A1.getBalance());
		
		assertFalse(A1.withdraw(-90));
		assertEquals(110,A1.getBalance());
	}

}

