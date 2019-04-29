package com.bank.authentication.controller.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.authentication.model.CustomerDetails;
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
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(10), "", "", "", "", "", "", "", "", "","");

		Mockito.when(authentationService.authenticateCustomer(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(customer);

		@SuppressWarnings("rawtypes")
		ResponseEntity responseEntity = authenticationControllerImpl.authenticateUser("Arindam", "Bhaumik");
		assertEquals(200, responseEntity.getStatusCode().value());
	}
}
