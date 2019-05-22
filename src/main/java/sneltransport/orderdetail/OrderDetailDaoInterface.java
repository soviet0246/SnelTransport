package sneltransport.orderdetail;

import java.util.List;

public interface OrderDetailDaoInterface {
	List<OrderDetail> getAllOrderDetails();

	OrderDetail getOrderDetailById(int orderDetailId);

	OrderDetail addOrderDetail(OrderDetail orderDetail);

	void updateOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetail(int orderDetailId);

}
