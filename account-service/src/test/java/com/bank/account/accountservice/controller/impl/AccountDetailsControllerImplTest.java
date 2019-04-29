package com.bank.account.accountservice.controller.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.account.accountservice.model.Account;
import com.bank.account.accountservice.service.AccountDetailsService;

/**
 * Account Details service resource.
 * 
 * @author Arindam Bhaumik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AccountDetailsControllerImplTest {
	@Mock
	AccountDetailsService accountDetailsService;

	@InjectMocks
	private AccountDetailsControllerImpl accountDetailsControllerImpl;

	@Test
	public void testAuthenticateUser() {
		Account account = new Account();
		List<Account> accountList = new ArrayList<Account>();
		accountList.add(account);

		Mockito.when(accountDetailsService.retrieveAccounts(Mockito.anyLong())).thenReturn(accountList);
		List<Account> accountListFromService = accountDetailsControllerImpl.retrieveAccounts(new Long(10));
		assertEquals(accountListFromService.size(), 1);
	}
}
