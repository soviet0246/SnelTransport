package sneltransport.orderdetail;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import sneltransport.articles.Article;

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
	
//	@Column(name = "order_id", nullable = false)
//	@NotNull
//	private int order_id;
	
//	@Column(name = "article", nullable = false)
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
