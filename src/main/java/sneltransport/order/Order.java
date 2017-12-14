package sneltransport.order;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import sneltransport.orderdetail.OrderDetail;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id", nullable = false, unique = true)
	@NotNull
	@JsonProperty("order_id")
	private int orderId;

	@Column(name = "customer_id", nullable = false)
	@NotNull
	@JsonProperty("customer_id")
	private int customerId;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type")
	@NotNull
	@JsonProperty("order_type")
	private OrderType orderType;

	// private CustomerId Auto linken
	@Column(name = "order_date_time", nullable = false)
	@NotNull
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonProperty("order_date_time")
	private LocalDateTime dateAndTimeOrderMade = LocalDateTime.now();

	@Column(name = "order_received", nullable = false)
	@NotNull
	@JsonProperty("order_received")
	private boolean orderReceived = false;

	@Column(name = "order_delivered", nullable = false)
	@NotNull
	@JsonProperty("order_delivered")
	private boolean orderDelivered = false;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	@JoinColumn(name = "order_id", nullable = false)
	@JsonProperty("order_details")
	private Set<OrderDetail> orderDetails;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public LocalDateTime getDateAndTimeOrderMade() {
		return dateAndTimeOrderMade;
	}

	public void setDateAndTimeOrderMade(LocalDateTime dateAndTimeOrderMade) {
		this.dateAndTimeOrderMade = dateAndTimeOrderMade;
	}

	public boolean isOrderReceived() {
		return orderReceived;
	}

	public void setOrderReceived(boolean orderReceived) {
		this.orderReceived = orderReceived;
	}

	public boolean isOrderDelivered() {
		return orderDelivered;
	}

	public void setOrderDelivered(boolean orderDelivered) {
		this.orderDelivered = orderDelivered;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}