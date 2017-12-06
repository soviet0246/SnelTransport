package sneltransport.customer;

import java.util.List;

public interface CustomerDaoInterface {
	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);

	Customer addCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomer(int customerId);

}
