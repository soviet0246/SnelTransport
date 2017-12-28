package sneltransport.articles;

import java.util.List;

public interface ArticleDaoInterface {
	List<Article> getAllArticles();

	Article getArticleById(String articleId);

	Article addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

}
