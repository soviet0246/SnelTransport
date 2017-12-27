package sneltransport.articles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ArticleDaoImplementation implements ArticleDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	/*
	 * @todo: Add paging functionality
	 */
	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		String hql = "FROM Article as article ORDER BY article.articleId";
		return entityManager.createQuery(hql, Article.class).getResultList();
	}

	@Transactional
	public Article addArticle(Article article) {
		entityManager.persist(article);
		return entityManager.find(Article.class, article.getArticleId());
	}

	@Transactional
	public void updateArticle(Article article) {
		entityManager.merge(article);
	}

	@Transactional
	public void deleteArticle(int articleId) {
		entityManager.remove(articleId);
	}
}
