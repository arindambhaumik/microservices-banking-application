package com.bank.authentication.controller.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.authentication.entity.Login;
import com.bank.authentication.exception.AuthenticationException;
import com.bank.authentication.exception.RegistrationException;
import com.bank.authentication.model.CustomerDetails;
import com.bank.authentication.model.RegistrationResponse;
import com.bank.authentication.service.AuthentationService;

/**
 * Responsible for authentication tasks (login, registration etc.).
 * 
 * @author Arindam Bhaumik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthenticationControllerImplTest {
	@Mock
	AuthentationService authentationService;

	@InjectMocks
	private AuthenticationControllerImpl authenticationControllerImpl;

	@Test
	public void testAuthenticateUser() throws Exception {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(10), "", "", "", "", "", "", "", "", "",
				"");

		Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customer);

		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = authenticationControllerImpl.authenticateUser("Arindam", "Bhaumik");
		assertEquals(200, responseEntity.getStatusCode().value());
	}

	/**
	 * Negative test cases
	 * 
	 * @throws AuthenticationException
	 */
	@Test
	public void testAuthenticateUserNegetive() throws AuthenticationException {
		/*
		 * CustomerDetails customer = new CustomerDetails(new Long(10), new Long(10),
		 * "", "", "", "", "", "", "", "", "", "");
		 */
		Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new AuthenticationException("Authentication failed", 500));

		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = authenticationControllerImpl.authenticateUser("Arindam", "Bhaumik");
		assertEquals(500, responseEntity.getStatusCode().value());
	}

	/**
	 * @throws RegistrationException
	 * @throws AuthenticationException 
	 * 
	 */
	@Test
	public void testCustomerRegistration() throws RegistrationException, AuthenticationException {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(12345), "", "", "", "", "", "", "", "",
				"", "");
		Login login = new Login(new Long(12345), "Arindam", "Bhaumik");

		Mockito.when(authentationService.recordLoginDetails(login)).thenReturn(true);
		/*
		 * Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(),
		 * Mockito.anyString())) .thenReturn(customer);
		 */
		
		RegistrationResponse responseEntity = authenticationControllerImpl.registerCustomer(customer, login.getUsername(),
				login.getPassword());
		assertEquals(Boolean.TRUE, responseEntity.isRegistered());
	}
}
