package sneltransport.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderDaoInterface orderDAO;

	public Order getOrderById(int orderId) {
		Order obj = orderDAO.getOrderById(orderId);
		return obj;
	}

	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Transactional
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	public void deleteOrder(int OrderId) {
		orderDAO.deleteOrder(OrderId);
	}
}
