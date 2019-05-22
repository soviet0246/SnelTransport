package sneltransport.order;

import java.util.List;

public interface OrderDaoInterface {
	List<Order> getAllOrders();

	Order getOrderById(int orderId);

	Order addOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(int orderId);

}
