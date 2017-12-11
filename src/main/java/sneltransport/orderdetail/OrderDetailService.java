package sneltransport.orderdetail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderDetailService {
	
	@Autowired
	private OrderDetailDaoInterface orderDetailDAO;

	public OrderDetail getOrderDetailById(int orderDetailId) {
		OrderDetail obj = orderDetailDAO.getOrderDetailById(orderDetailId);
		return obj;
	}

	public List<OrderDetail> getAllOrderDetails() {
		return orderDetailDAO.getAllOrderDetails();
	}

//	@Transactional
	public void addOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.addOrderDetail(orderDetail);
	}

	public void updateOrderDetail(OrderDetail orderDetail) {
		orderDetailDAO.updateOrderDetail(orderDetail);
	}

	public void deleteOrderDetail(int OrderDetailId) {
		orderDetailDAO.deleteOrderDetail(OrderDetailId);
	}
}
