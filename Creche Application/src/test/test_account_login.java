package test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import creche.impl.*;

public class test_account_login {
	Account acc;
	@Before
	public void setUp() throws Exception {
		acc = new Account();
		acc.setUserId(1);
		acc.setAccountType(Account.accountType.STAFF.name());
		acc.setPassword("ABC123");
	}

	@Test
	public void testSuccessLogin() {
		assertTrue(acc.login(1, Account.accountType.STAFF.name(), "ABC123"));
	}
	
	@Test
	public void testFailLogin() {
		assertFalse(acc.login(1, Account.accountType.STAFF.name(), "ABC124"));
	}
	
	@Test
	public void testResetPassword() {
		String oldPassword = acc.getPassword();
		acc.resetPassword();
		String newPassword = acc.getPassword();
		assertNotEquals(oldPassword, newPassword);
	}
	
	

}
