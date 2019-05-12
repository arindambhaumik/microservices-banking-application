package com.bank.authentication.controller.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

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

	/**
	 * test cases for happy path
	 * 
	 * @throws Exception
	 */
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
	 * Nagetive test cases
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAuthenticateUserNagetive() throws Exception {
		Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(null);

		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = authenticationControllerImpl.authenticateUser("Arindam", "Bhaumik");
		assertEquals(401, responseEntity.getStatusCode().value());
	}
	
	/**
	 * Negative test cases
	 * 
	 * @throws AuthenticationException
	 */
	@Test
	public void testAuthenticateUserException() throws AuthenticationException {
		Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new AuthenticationException("Authentication failed", 500));

		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = authenticationControllerImpl.authenticateUser("Arindam", "Bhaumik");
		assertEquals(500, responseEntity.getStatusCode().value());
	}

	/**
	 * test cases for happy path
	 * 
	 * @throws RegistrationException
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomerRegistration() throws RegistrationException {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(12345), "", "", "", "", "", "", "", "",
				"", "");

		Mockito.when(authentationService.recordLoginDetails(Mockito.anyObject())).thenReturn(true);

		RegistrationResponse responseEntity = authenticationControllerImpl.registerCustomer(customer, "Arindam",
				"Bhaumik");
		assertEquals(Boolean.TRUE, responseEntity.isRegistered());
	}

	/**
	 * Negative test cases
	 * 
	 * @throws RegistrationException
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomerRegistrationNegetive() throws RegistrationException {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(12345), "", "", "", "", "", "", "", "",
				"", "");

		Mockito.when(authentationService.recordLoginDetails(Mockito.anyObject())).thenReturn(false);

		RegistrationResponse responseEntity = authenticationControllerImpl.registerCustomer(customer, "Arindam",
				"Bhaumik");
		assertEquals(500, responseEntity.getStatus());
	}

	/**
	 * Exception test cases
	 * 
	 * @throws RegistrationException
	 * 
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCustomerRegistrationException() throws RegistrationException {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(12345), "", "", "", "", "", "", "", "",
				"", "");

		Mockito.when(authentationService.recordLoginDetails(Mockito.anyObject()))
				.thenThrow(new RegistrationException("User registration failed", 500));

		RegistrationResponse responseEntity = authenticationControllerImpl.registerCustomer(customer, "Arindam",
				"Bhaumik");
		assertEquals(500, responseEntity.getStatus());
	}
}
