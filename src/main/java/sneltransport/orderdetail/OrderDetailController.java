package sneltransport.orderdetail;

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
@RequestMapping("orderDetails")
public class OrderDetailController {
	@Autowired
	private OrderDetailService orderDetailService;

	@GetMapping("orderDetail/{id}")
	public ResponseEntity<OrderDetail> getArticleById(@PathVariable("id") Integer id) {
		OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
		return new ResponseEntity<OrderDetail>(orderDetail, HttpStatus.OK);
	}

	@GetMapping("orderDetails")
	public ResponseEntity<List<OrderDetail>> getAllOrderDetails() {
		List<OrderDetail> list = orderDetailService.getAllOrderDetails();
		return new ResponseEntity<List<OrderDetail>>(list, HttpStatus.OK);
	}

	@PostMapping("orderDetail/add")
	public ResponseEntity<Void> addArticle(@RequestBody OrderDetail orderDetail, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();

		orderDetailService.addOrderDetail(orderDetail);

		headers.setLocation(builder.path("/orderDetails/{id}").buildAndExpand(orderDetail.getOrderDetailId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("orderDetails")
	public ResponseEntity<OrderDetail> updateArticle(@RequestBody OrderDetail article) {
		orderDetailService.updateOrderDetail(article);
		return new ResponseEntity<OrderDetail>(article, HttpStatus.OK);
	}

	@DeleteMapping("orderDetails/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		orderDetailService.deleteOrderDetail(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
