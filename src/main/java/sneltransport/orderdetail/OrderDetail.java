package sneltransport.orderdetail;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import sneltransport.articles.Article;
import sneltransport.order.Order;

@Entity
@Table(name = "Order_details")
public class OrderDetail implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_detail_id", nullable = false, unique = true)
	@NotNull
	private int order_detail_id;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class)
	@NotNull
	private Order order;
	
	@NotNull
	@OneToOne
	private Article article;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity = 0;

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
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
