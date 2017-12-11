package sneltransport.order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Order addOrder(Order order) {
		
//		System.out.println("Order size" + order.getOrder_details().size());
		
		entityManager.persist(order);
		entityManager.flush();
		
		System.out.println("Dit word eerst nog uitgevoerd");
		
		return entityManager.find(Order.class, order.getOrder_id());
	}
	@Transactional
	public void updateOrder(Order order) {
		entityManager.merge(order);
	}
	@Transactional
	public void deleteOrder(int orderId) {
		entityManager.remove(orderId);
	}
}
