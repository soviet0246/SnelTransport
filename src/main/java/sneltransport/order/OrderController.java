package sneltransport.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("orders/{id}")
	public ResponseEntity<Order> getArticleById(@PathVariable("id") Integer id) {
		Order order = orderService.getOrderById(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@GetMapping("orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

	@PostMapping("orders")
	public ResponseEntity<Void> addArticle(@RequestBody Order order, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		
		orderService.addOrder(order);
		
		headers.setLocation(builder.path("/orders/{id}").buildAndExpand(order.getOrderId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("orders")
	public ResponseEntity<Order> updateArticle(@RequestBody Order article) {
		orderService.updateOrder(article);
		return new ResponseEntity<Order>(article, HttpStatus.OK);
	}

	@DeleteMapping("orders/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
