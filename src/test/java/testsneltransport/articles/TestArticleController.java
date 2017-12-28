package testsneltransport.articles;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneltransport.articles.Article;
import sneltransport.articles.ArticleController;
import sneltransport.articles.ArticleService;
import sneltransport.articles.ArticleType;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TestArticleController {

	@Mock
	private ArticleService articleService;

	@InjectMocks
	private ArticleController articleController;

	private MockMvc mockMVC;

	@Before
	public void setUp() {
		mockMVC = MockMvcBuilders.standaloneSetup(articleController).build();
	}

	/**
	 * Test {@link ArticleController#getAllArticles()} met MockMvc
	 * 
	 * @throws Exception
	 *             not expected
	 */
	@Test
	public void getListOfAllarticles() throws Exception {
		// prepare
		List<Article> allArticles = getAllArticles();
		when(articleService.getAllArticles()).thenReturn(allArticles);

		ObjectMapper mapper = new ObjectMapper();
		String expectedContent = mapper.writeValueAsString(allArticles);

		// execute & verify
		mockMVC.perform(get("/articles/articles")).andExpect(status().isOk())
				.andExpect(content().string(expectedContent));
	}

	@Test
	public void testGetSpecificArticleById() throws Exception {

		String articleId = "1";
		Article article = makeArticle("GEEL", "1", "mobo", 1.0, ArticleType.BOARD);

		when(articleService.getArticleById(articleId)).thenReturn(article);

		ObjectMapper mapper = new ObjectMapper();
		String expectedContent = mapper.writeValueAsString(article);

		mockMVC.perform(get("/articles/article/" + articleId)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string(expectedContent));
	}
	
	@Test
	public void testUpdateArticle() throws Exception {

		Article article = makeArticle("GEEL", "1", "mobo", 1.0, ArticleType.BOARD);

		mockMVC.perform(put("/articles/articles/")).andExpect(MockMvcResultMatchers.status().is(400));
	}

	private List<Article> getAllArticles() {
		return Arrays.asList(makeArticle("GEEL", "1", "mobo", 1.0, ArticleType.BOARD),
				makeArticle("ROOD", "2", "scherm", 2.0, ArticleType.DISPLAYS));
	}

	private Article makeArticle(String color, String id, String name, double price, ArticleType type) {
		Article article = new Article();
		article.setArticleColor(color);
		article.setArticleId(id);
		article.setArticleName(name);
		article.setArticlePrice(price);
		article.setArticleType(type);
		return article;
	}
}
