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

@Entity
@Table(name = "Article")
public class Article implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "article_Id", nullable = false, unique = true)
	@NotNull
	private String article_id;

	@Column(name = "article_name", nullable = false)
	@NotNull
	private String article_name;

	@Column(name = "article_price", nullable = false)
	@NotNull
	private Double article_price;

	@Column(name = "article_type")
	private String articleType;

	@Column(name = "article_color")
	@Enumerated(EnumType.STRING)
	private ArticleColor article_color;

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getArticle_name() {
		return article_name;
	}

	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}

	public Double getArticle_price() {
		return article_price;
	}

	public void setArticle_price(Double article_price) {
		this.article_price = article_price;
	}

	public String getArticleType() {
		return articleType;
	}

	public void setArticleType(String articleType) {
		this.articleType = articleType;
	}

	public ArticleColor getArticle_color() {
		return article_color;
	}

	public void setArticle_color(ArticleColor article_color) {
		this.article_color = article_color;
	}
}
