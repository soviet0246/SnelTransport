package sneltransport.order;

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
@RequestMapping("orders")
public class OrderController {
	@Autowired
	private OrderService orderService;

	@GetMapping("order/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) {
		Order order = orderService.getOrderById(id);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@GetMapping("orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = orderService.getAllOrders();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}

	
	@PostMapping("order/add")
	public ResponseEntity<Void> addOrder(@RequestBody Order order, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();
		
		orderService.addOrder(order);
		
		headers.setLocation(builder.path("/order/{id}").buildAndExpand(order.getOrderId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("orders")
	public ResponseEntity<Order> updateOrder(@RequestBody Order article) {
		orderService.updateOrder(article);
		return new ResponseEntity<Order>(article, HttpStatus.OK);
	}

	@DeleteMapping("order/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("id") Integer id) {
		orderService.deleteOrder(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
