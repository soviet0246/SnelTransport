package testsneltransport.order;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import sneltransport.articles.Article;
import sneltransport.articles.ArticleColor;
import sneltransport.articles.ArticleController;
import sneltransport.articles.ArticleType;
import sneltransport.order.Order;
import sneltransport.order.OrderController;
import sneltransport.order.OrderService;
import sneltransport.orderdetail.OrderDetail;

@RunWith(MockitoJUnitRunner.class)
@WebAppConfiguration
public class TestOrderController {

	@Mock
	private OrderService orderService;

	@InjectMocks
	private OrderController orderController;

	private MockMvc mockMVC;

	@Before
	public void setUp() {
		mockMVC = MockMvcBuilders.standaloneSetup(orderController).build();
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
		List<Order> allOrders = getAllOrders();
		when(orderService.getAllOrders()).thenReturn(allOrders);

		ObjectMapper mapper = new ObjectMapper();
		String expectedContent = mapper.writeValueAsString(allOrders);

		// execute & verify
		mockMVC.perform(get("/orders/orders")).andExpect(status().isOk()).andExpect(content().string(expectedContent));
	}

	@Test
	public void testGetSpecificOrderById() throws Exception {

		int orderId = 1;
		Order order = makeOrder(1, LocalDateTime.now());

		when(orderService.getOrderById(orderId)).thenReturn(order);

		ObjectMapper mapper = new ObjectMapper();
		String expectedContent = mapper.writeValueAsString(order);

		mockMVC.perform(get("/orders/order/" + orderId)).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(content().string(expectedContent));
	}

	@Test
	public void testUpdateOrderFailure() throws Exception {

		Order order = makeOrder(1, LocalDateTime.now());
		doThrow(IllegalArgumentException.class).when(orderService).updateOrder(order);

		mockMVC.perform(put("/orders/order/")).andExpect(MockMvcResultMatchers.status().is(400));
	}

//	@Test
//	public void testUpdateOrderSuccess() throws Exception {
//		Order order = makeOrder(1, LocalDateTime.now());
//
//		ArgumentCaptor<Order> argument = ArgumentCaptor.forClass(Order.class);
//		verify(mockMVC).someMethod(argument.capture());
//		assertEquals("John", argument.getValue().getCustomerId());
//
//		doNothing().when(orderService).updateOrder(Matchers.any(Order.class));
//
//		// execute & verify
//		mockMVC.perform(put("/orders/order")).andExpect(status().isOk());
//
//	}

	private Article makeArticle() {
		Article article = new Article();
		article.setArticleId("1");
		article.setArticleColor(ArticleColor.GRIJS);
		article.setArticleName("blabla");
		article.setArticlePrice(13.44d);
		article.setArticleType(ArticleType.COMPUTERS);
		return article;
	}

	private OrderDetail makeOrderDetail(int orderDetailId) {
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setQuantity(1);
		orderDetail.setArticle(makeArticle());
		orderDetail.setOrderDetailId(orderDetailId);
		return orderDetail;
	}

	private List<Order> getAllOrders() {
		return Arrays.asList(makeOrder(1, LocalDateTime.now()), makeOrder(2, LocalDateTime.now()));
	}

	private Order makeOrder(int customerId, LocalDateTime dateAndTimeOrderMade) {
		Order order = new Order();
		Set<OrderDetail> orderDetailSet = new HashSet<>();
		orderDetailSet.add(makeOrderDetail(1));

		order.setCustomerId(customerId);
		order.setDateAndTimeOrderMade(dateAndTimeOrderMade);
		order.setOrderDetails(orderDetailSet);

		return order;
	}
}
