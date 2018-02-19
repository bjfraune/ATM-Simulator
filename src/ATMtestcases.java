import static org.junit.Assert.*;

import org.junit.Test;
/**
 * @author BS
 *	Test cases per lab4 pdf
 */
public class ATMtestcases {
	/**
	 * Successful	validate	and	withdrawal	of	$20	from	account	1234;
	 */
	@Test

	public void testA() {
		ATM.initialize();
		assertTrue(Bank.validate(1234,6789));
		Account Testing = Bank.getAcc(1234);
		assertTrue(Testing.withdrawl(20));
	}
	/**
	 * Successful	validate	and	withdrawal	of	$80	from	account	1234;
	 */
	@Test
	public void testB() {
		ATM.initialize();
		assertTrue(Bank.validate(1234, 6789));
		Account Testing = Bank.getAcc(1234);
		assertTrue(Testing.withdrawl(80));
	}
	/**
	 * Incorrect	validation	on	account	6789;
	 */
	@Test
	public void testC() {
		ATM.initialize();
		assertFalse(Bank.validate(1, 4321));
		assertFalse(Bank.validate(6789, 1));
	}
	/**
	 * Successful	deposit	of	$20	to	account	6789;
	 */
	@Test
	public void testD() {
		ATM.initialize();
		assertTrue(Bank.validate(6789, 4321));
		Account Testing = Bank.getAcc(6789);
		assertTrue(Testing.deposit(20));
	}
	/**
	 * Check withdrawing negatives, deposit negs, withdrawing more than acc bal, etc
	 */
	@Test
	public void testE() {
		ATM.initialize();
		assertTrue(Bank.validate(1234, 6789));
		Account Testing = Bank.getAcc(1234);
		assertFalse(Testing.withdrawl(-1));
		assertEquals(80, Testing.getBalance(), 0);
		assertFalse(Testing.withdrawl(81));
		assertFalse(Testing.deposit(-1));
	}




}
