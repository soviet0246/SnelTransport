package sneltransport.orderdetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {

	@Autowired
	private OrderDetailDaoInterface orderDetailDAO;

	public OrderDetail getOrderDetailById(int orderDetailId) {
		return orderDetailDAO.getOrderDetailById(orderDetailId);
	}

	public List<OrderDetail> getAllOrderDetails() {
		return orderDetailDAO.getAllOrderDetails();
	}

	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.addOrderDetail(orderDetail);
	}

	public void updateOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.updateOrderDetail(orderDetail);
	}

	public void deleteOrderDetail(int orderDetailId) {
		orderDetailDAO.deleteOrderDetail(orderDetailId);
	}
}
