package dao;

import java.util.Date;
import java.util.List;

import pojos.Customer;

public interface CustomerDao {
	String registerCustomer(Customer c);
	Customer getCustomerById(int id);
	List<Customer> getAllCustomers();
	List<Customer> getSelectedCustomers(Date d1,double amt);
	List<Customer> updateCustomerDetails(Date d1,double discount);
	int bulkUpdateCustomerDetails(Date d1,double discount);
	List<Customer> unsubscribeCustomer(String role);
	
}
