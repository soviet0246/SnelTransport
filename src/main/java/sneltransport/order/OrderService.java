package sneltransport.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	private OrderDaoInterface orderDAO;

	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}

	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	public void deleteOrder(int orderId) {
		orderDAO.deleteOrder(orderId);
	}
}
