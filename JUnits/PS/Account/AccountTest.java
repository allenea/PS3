package PS.Account;

import PS.Account.InsufficientFundsException;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AccountTest {

	Account c;
	
	@Before
	public void setUp() throws Exception {
		c = new Account(1122, 20000, 4.5);
	}

	@After
	public void tearDown() throws Exception {
		c = null;
	}

	@Test(expected=InsufficientFundsException.class)
	public final void testWithdraw() throws InsufficientFundsException {
		c.deposit(500.00);
		assertEquals("$400 Expected, actual is $500",(long)c.getBalance(),(long)20500);
        c.withdraw(20900);
	
      
		c.deposit(3000.00);
        c.withdraw(2500);
		assertEquals("$500 Expected, actual is $500",(long)c.getBalance(),(long)20500.00);
	}
	
	@Test
	public final void testDeposit() {

		c.deposit(3000);
	
		assertEquals("Expected $3000, actual is $3000",(long)c.getBalance(),(long)23000.00);
	}


	@Test
	public final void testGetBalance() {
		assertEquals("Expected $20000, actual is $20000",(long)c.getBalance(),(long)20000.00);

	}

	@Test
	public final void testGetID() {
		assertEquals("1122",(long)c.getId(),(long)1122);

	}
	@Test
	public final void testGetAnnualInterestRate() {
		assertEquals("4.5%",(long)c.getAnnualIntrestRate(),(long).0045);

	}
	@Test
	public final void testGetMonthlyInterestRate() {
		assertEquals(".375%",(long)c.getMonthlyInterestRate(),(long).00375);
	}
	@Test
	public final void testGetMonthlyInterest() {
		assertEquals("$75",(long)c.getMonthlyInterest(),(long)75.00);
	}
	

}


