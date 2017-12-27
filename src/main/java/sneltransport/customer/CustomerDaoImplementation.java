package sneltransport.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDaoImplementation implements CustomerDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
	}

	/*
	 * @todo: Add paging functionality
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		String hql = "FROM Customer as customer ORDER BY customer.customerId";
		return entityManager.createQuery(hql, Customer.class).getResultList();
	}

	@Transactional
	public Customer addCustomer(Customer customer) {
		entityManager.persist(customer);
		return entityManager.find(Customer.class, customer.getCustomerId());
	}

	@Transactional
	public void updateCustomer(Customer customer) {
		entityManager.merge(customer);
	}

	@Transactional
	public void deleteCustomer(int customerId) {
		entityManager.remove(customerId);
	}
}
