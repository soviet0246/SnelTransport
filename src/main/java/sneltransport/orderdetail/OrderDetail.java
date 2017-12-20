package sneltransport.orderdetail;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import sneltransport.articles.Article;
import sneltransport.order.Order;

@Entity
@Table(name = "Order_detail")
public class OrderDetail implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id", nullable = false, unique = true)
	@NotNull
	@JsonProperty("order_detail_id")
	private int orderDetailId;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
	private Order order;

	@NotNull
	@OneToOne
	private Article article;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity = 0;

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}