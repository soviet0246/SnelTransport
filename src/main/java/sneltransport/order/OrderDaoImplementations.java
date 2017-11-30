package sneltransport.order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImplementations implements OrderDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	public Order getOrderById(int orderId) {
		return entityManager.find(Order.class, orderId);
	}

	@SuppressWarnings("unchecked")
	public List<Order> getAllOrders() {
		String hql = "FROM Order as order ORDER BY order.orderId";
		return (List<Order>) entityManager.createQuery(hql).getResultList();
	}

	public Order addOrder(Order order) {
		entityManager.persist(order);
		return entityManager.find(Order.class, order.getOrderId());
	}

	public void updateOrder(Order order) {
		entityManager.merge(order);
	}

	public void deleteOrder(int orderId) {
		entityManager.remove(orderId);
	}
}
