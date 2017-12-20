package sneltransport.articles;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "article_id", nullable = false, unique = true)
	@JsonProperty("article_id")
	private String articleId;

	@Column(name = "article_name", nullable = false)
	@NotNull
	@JsonProperty("article_name")
	private String articleName;

	@Column(name = "article_price", nullable = false)
	@NotNull
	@JsonProperty("article_price")
	private Double articlePrice;

	@Column(name = "article_color")
	@Enumerated(EnumType.STRING)
	@JsonProperty("article_color")
	private ArticleColor articleColor;

	@Enumerated(EnumType.STRING)
	@Column(name = "article_type")
	@NotNull
	private ArticleType articleType;

	@Enumerated(EnumType.STRING)
	@Column(name = "article_warehouse_location")
	@NotNull
	@JsonProperty("warehouse_location")
	private WarehouseLocation warehouseLocation;

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public Double getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(Double articlePrice) {
		this.articlePrice = articlePrice;
	}

	public ArticleColor getArticleColor() {
		return articleColor;
	}

	public void setArticleColor(ArticleColor articleColor) {
		this.articleColor = articleColor;
	}

	public ArticleType getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleType articleType) {
		this.articleType = articleType;
	}

	public WarehouseLocation getWarehouseLocation() {
		return warehouseLocation;
	}

	public void setWarehouseLocation(WarehouseLocation warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}
}
