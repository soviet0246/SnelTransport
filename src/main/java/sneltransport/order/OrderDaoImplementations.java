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
		String hql = "FROM Order as order ORDER BY order.order_id";
		return (List<Order>) entityManager.createQuery(hql).getResultList();
	}

	public Order addOrder(Order order) {
		
//		System.out.println("Order size" + order.getOrder_details().size());
		
		entityManager.persist(order);
		return entityManager.find(Order.class, order.getOrder_id());
	}

	public void updateOrder(Order order) {
		entityManager.merge(order);
	}

	public void deleteOrder(int orderId) {
		entityManager.remove(orderId);
	}
}
