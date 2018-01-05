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
	 * Version ID of Article class
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

	@Column(name = "article_price")
	@JsonProperty("article_price")
	private Double articlePrice;

	@Column(name = "article_color")
	@JsonProperty("article_color")
	@Enumerated(EnumType.STRING)
	private ArticleColor articleColor;

	@Column(name = "article_type")
	@Enumerated(EnumType.STRING)
	@NotNull
	private ArticleType articleType;

	@Column(name = "article_warehouse_location")
	@NotNull
	@Enumerated(EnumType.STRING)
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

	public void setArticleColor(ArticleColor color) {
		this.articleColor = color;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleColor == null) ? 0 : articleColor.hashCode());
		result = prime * result + ((articleId == null) ? 0 : articleId.hashCode());
		result = prime * result + ((articleName == null) ? 0 : articleName.hashCode());
		result = prime * result + ((articlePrice == null) ? 0 : articlePrice.hashCode());
		result = prime * result + ((articleType == null) ? 0 : articleType.hashCode());
		result = prime * result + ((warehouseLocation == null) ? 0 : warehouseLocation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (articleColor != other.articleColor)
			return false;
		if (articleId == null) {
			if (other.articleId != null)
				return false;
		} else if (!articleId.equals(other.articleId))
			return false;
		if (articleName == null) {
			if (other.articleName != null)
				return false;
		} else if (!articleName.equals(other.articleName))
			return false;
		if (articlePrice == null) {
			if (other.articlePrice != null)
				return false;
		} else if (!articlePrice.equals(other.articlePrice))
			return false;
		if (articleType != other.articleType)
			return false;
		if (warehouseLocation != other.warehouseLocation)
			return false;
		return true;
	}

}
