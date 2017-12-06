package sneltransport.articles;

import java.util.List;

public interface ArticleDaoInterface {
	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	Article addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

}
