package sneltransport.orderdetail;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Order_detail")
public class OrderDetail implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_detail_id", nullable = false, unique = true)
	@NotNull
	private int order_detail_id;
	
	@Column(name = "order_id", nullable = false)
	@NotNull
	private int order_id;
	
	@Column(name = "article_id", nullable = false)
	@NotNull
	private int article_id;

	@Column(name = "quantity", nullable = false)
	@NotNull
	private int quantity = 0;

	public int getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getArticle_id() {
		return article_id;
	}

	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
