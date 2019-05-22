package sneltransport.order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDaoImplementation implements OrderDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	public Order getOrderById(int orderId) {
		return entityManager.find(Order.class, orderId);
	}

	/*
	 * @todo: Add paging functionality
	 */
	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		String hql = "FROM Order as order where order.orderStatus = false ORDER BY order.orderId";
		return entityManager.createQuery(hql, Order.class).getResultList();
	}
	@Transactional
	public Order addOrder(Order order) {
		entityManager.persist(order);
		entityManager.flush();
		return entityManager.find(Order.class, order.getOrderId());
	}
	@Transactional
	public void updateOrder(Order order) {
		entityManager.merge(order);
	}
	@Transactional
	public void deleteOrder(int orderId) {
		Order order = entityManager.find(Order.class, orderId);
		entityManager.remove(order);
	}
}
