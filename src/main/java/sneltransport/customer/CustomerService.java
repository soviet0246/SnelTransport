package sneltransport.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDaoInterface customerDAO;

	public Customer getCustomerById(int customerId) {
		Customer obj = customerDAO.getCustomerById(customerId);
		return obj;
	}

	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}

	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	public void deleteCustomer(int CustomerId) {
		customerDAO.deleteCustomer(CustomerId);
	}
}
