package sneltransport.customer;

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
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> getArticleById(@PathVariable("id") Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerService.getAllCustomers();
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	
	@PostMapping("customer/add")
	public ResponseEntity<Void> addArticle(@RequestBody Customer customer, UriComponentsBuilder builder) {
		HttpHeaders headers = new HttpHeaders();

		customerService.addCustomer(customer);

		headers.setLocation(builder.path("/customers/{id}").buildAndExpand(customer.getCustomer_id()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("customers")
	public ResponseEntity<Customer> updateArticle(@RequestBody Customer article) {
		customerService.updateCustomer(article);
		return new ResponseEntity<Customer>(article, HttpStatus.OK);
	}

	@DeleteMapping("customers/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
