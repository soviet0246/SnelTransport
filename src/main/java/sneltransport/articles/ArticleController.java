package sneltransport.articles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@CrossOrigin
@RequestMapping("articles")
public class ArticleController {

	@Autowired
	private ArticleService articleService;

	@GetMapping("articles/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = articleService.getArticleById(id);
		return new ResponseEntity<>(article, HttpStatus.OK);
	}

	@GetMapping("articles")
	public ResponseEntity<List<Article>> getAllArticles() {
		List<Article> listOfArticles = articleService.getAllArticles();
		return new ResponseEntity<>(listOfArticles, HttpStatus.OK);
	}

	@PostMapping("article/add")
	public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();

		articleService.addArticle(article);

		headers.setLocation(builder.path("/articles/{id}").buildAndExpand(article.getArticleId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}

	@PutMapping("articles")
	public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
		articleService.updateArticle(article);
		return new ResponseEntity<>(article, HttpStatus.I_AM_A_TEAPOT);
	}

	@DeleteMapping("articles/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		articleService.deleteArticle(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
