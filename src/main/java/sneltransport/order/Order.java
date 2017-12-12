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
	private int order_id;

	@Column(name = "customer_id", nullable = false)
	@NotNull
	private int customer_id;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type")
	@NotNull
	private OrderType order_type;

	// private CustomerId Auto linken
	@Column(name = "order_date_time", nullable = false)
	@NotNull
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	private LocalDateTime dateAndTimeOrderMade = LocalDateTime.now();

	@Column(name = "order_received", nullable = false)
	@NotNull
	private boolean order_received = false;

	@Column(name = "order_delivered", nullable = false)
	@NotNull
	private boolean order_delivered = false;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "order_id", nullable = false)
	private Set<OrderDetail> order_details;// = new ArrayList<OrderDetail>();

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id.intValue();
	}
	
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public OrderType getOrder_type() {
		return order_type;
	}

	public void setOrder_type(OrderType order_type) {
		this.order_type = order_type;
	}

	public LocalDateTime getDateAndTimeOrderMade() {
		return dateAndTimeOrderMade;
	}

	public void setDateAndTimeOrderMade(LocalDateTime dateAndTimeOrderMade) {
		this.dateAndTimeOrderMade = dateAndTimeOrderMade;
	}

	public boolean isOrder_received() {
		return order_received;
	}

	public void setOrder_received(boolean order_received) {
		this.order_received = order_received;
	}

	public boolean isOrderDelivered() {
		return order_delivered;
	}

	public void setOrderDelivered(boolean orderDelivered) {
		this.order_delivered = orderDelivered;
	}

	public boolean isOrder_delivered() {
		return order_delivered;
	}

	public void setOrder_delivered(boolean order_delivered) {
		this.order_delivered = order_delivered;
	}

	public Set<OrderDetail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Set<OrderDetail> order_details) {
		this.order_details = order_details;
	}
}