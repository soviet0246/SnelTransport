package sneltransport.orderdetail;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OrderDetailDaoImplementations implements OrderDetailDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public OrderDetail getOrderDetailById(int orderDetailId) {
		return entityManager.find(OrderDetail.class, orderDetailId);
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetail> getAllOrderDetails() {
		String hql = "FROM OrderDetail as order_detail ORDER BY order_detail.orderDetailId";
		return (List<OrderDetail>) entityManager.createQuery(hql).getResultList();
	}

	@Transactional
	public OrderDetail addOrderDetail(OrderDetail orderDetail) {
		entityManager.persist(orderDetail);
		return entityManager.find(OrderDetail.class, orderDetail.getOrderDetailId());
	}

	@Transactional
	public void updateOrderDetail(OrderDetail orderDetail) {
		entityManager.merge(orderDetail);
	}

	@Transactional
	public void deleteOrderDetail(int orderDetailId) {
		entityManager.remove(orderDetailId);
	}
}
