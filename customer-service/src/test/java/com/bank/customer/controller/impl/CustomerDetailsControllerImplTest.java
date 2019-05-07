package com.bank.customer.controller.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.customer.model.CustomerDetails;
import com.bank.customer.service.CustomerDetailsService;

/**
 * Customer Details service resource.
 * 
 * @author Arindam Bhaumik
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerDetailsControllerImplTest {
	@Mock
	CustomerDetailsService customerDetailsService;
	@InjectMocks
	CustomerDetailsControllerImpl customerDetailsControllerImpl;

	@Test
	public void testHealthCheck() {
		assertEquals("customer-service is healthy","customer-service is healthy");
	}
	
	@Test
	public void testRetrieveCustomer() {
		CustomerDetails customer = new CustomerDetails(new Long(10), new Long(10), "", "", "", "", "", "", "", "", "",
				"");
		List<CustomerDetails> customerList = new ArrayList<CustomerDetails>();
		customerList.add(customer);

		Mockito.when(customerDetailsService.retrieveCustomer((Mockito.anyLong()))).thenReturn(customerList);

		List<CustomerDetails> customerListFromService = customerDetailsControllerImpl.retrieveCustomer(10);
		assertEquals(customerListFromService.size(), 1);
	}
}
