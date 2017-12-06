package sneltransport.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDaoInterface articleDAO;

	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}

	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Transactional
	public void addArticle(Article article) {
		articleDAO.addArticle(article);
	}

	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
}
