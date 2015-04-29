package com.github.jlgrock.snp.core.data.test;

package com.github.jlgrock.snp.core.data;

public class dummy {

	public Customer createDummyCustomer() {
	 County county = new County("Essex");
	 City city = new City("Romford", county);
	 Address address = new Address("1234 Bank Street", city);
	 Customer customer = new Customer("john", "dobie", address);
	 return customer;
	}

	@Test
	public void addCustomerTest() {
	 Customer dummy = createDummyCustomer();
	 AddressBook addressBook = new AddressBook();
	 addressBook.addCustomer(dummy);
	 assertEquals(1, addressBook.getNumberOfCustomers());
	}

	
	
	
	
	@Test(expected=Exception.class)
	public void addNullCustomerTest() {
	 Customer dummy = null;
	 AddressBook addressBook = new AddressBook();
	 addressBook.addCustomer(dummy);
	}  
	
	
	
	
	
	@Test
	public void addCustomerWithDummyTest() {
	 Customer dummy = mock(Customer.class);
	 AddressBook addressBook = new AddressBook();
	 addressBook.addCustomer(dummy);
	 Assert.assertEquals(1, addressBook.getNumberOfCustomers());
	}
	
	
	
	
	
	Customer dummy = mock(Customer.class);
	
}
