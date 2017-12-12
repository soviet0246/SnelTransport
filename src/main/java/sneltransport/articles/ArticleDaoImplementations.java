package sneltransport.articles;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImplementations implements ArticleDaoInterface {
	@PersistenceContext
	private EntityManager entityManager;

	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}

	@SuppressWarnings("unchecked")
	public List<Article> getAllArticles() {
		String hql = "FROM Article as article ORDER BY article.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}

	public Article addArticle(Article article) {
		entityManager.persist(article);
		return entityManager.find(Article.class, article.getArticleId());
	}

	public void updateArticle(Article article) {
		entityManager.merge(article);
	}

	public void deleteArticle(int articleId) {
		entityManager.remove(articleId);
	}
}
