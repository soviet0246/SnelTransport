package testsneltransport.articles;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import sneltransport.articles.Article;
import sneltransport.articles.ArticleColor;
import sneltransport.articles.ArticleController;
import sneltransport.articles.ArticleDaoInterface;
import sneltransport.articles.ArticleService;
import sneltransport.articles.ArticleType;
import sneltransport.articles.WarehouseLocation;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TestArticleController {
	private MockMvc mockMVC;
	private List<Article> ALL_ARTICLES;
//	private WarehouseLocation warehouseLocations = new WarehouseLocation();
//	private ArticleColor articleColors;
	
	@Mock
	private ArticleDaoInterface articleDAO;

	@InjectMocks
	private ArticleService articleService;

	@Before
	public void setup() {
		final ArticleController articleController = new ArticleController();
		ALL_ARTICLES = new ArrayList<>();

		Article testArticle = new Article();

		for (int i = 0; i < 101; i++) {

			testArticle = new Article();
//			testArticle.setArticleColor(ArticleColor.valueOf(ArticleColor.class, "GEEL"));
			testArticle.setArticleId("" + i);
			testArticle.setArticleName("" + testArticle.hashCode());
			testArticle.setArticlePrice((double) i);
			testArticle.setArticleType(ArticleType.BOARD);
//			testArticle.setWarehouseLocation(warehouseLocations.);

			ALL_ARTICLES.add(testArticle);
		}

		mockMVC = MockMvcBuilders.standaloneSetup(articleController).build();
	}

	@Test
	public void getListOfAllarticles() throws Exception {
		Mockito.when(articleService.getAllArticles()).thenReturn(ALL_ARTICLES);
		// Then
		mockMVC.perform(get("/articles/articles")).andExpect(MockMvcResultMatchers.status().isOk());
	}
}
