import static org.junit.Assert.*;

import org.junit.Test;


public class ATMtst {

	@Test
	public void test() {
		Bank bank = new Bank();
		Account A1 = new Account(1234,6789,80);
		Account A2 = new Account(6789,4321,60);
		//Account A3  = new Account(3442, 4321, 60);
		
		//validate the two accounts
		assertTrue(bank.validate(A1));
		assertTrue(bank.validate(A2));
		//assertFalse(bank.validate(5896));
		
		//validate the pin and balance
		//assertFalse(bank.validate(A3));
		assertFalse(A1.PINcode == 4321);
		assertFalse(A2.PINcode == 6789);
		assertFalse(A1.balamce < 0);
		assertfalse(A2.balance == 80);
		
		
		//validate the withdraw and deposit
		assertTrue(bank.deposit(50));
		assertFalse(bank.withdraw(200));
		assertTrue(bank.withdraw(20));
		assertEquals(110,A1.getBalance);
		
		assertTrue(bank.deposit(100));
		assertEquals(160,A2.balance);
		assertFalse(bank.withdraw(200));
		assertEquals(160, A2.balance);
		assertTrue(bank.withdraw(160));
		
	}

}
