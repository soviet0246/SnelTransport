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
	@Column(name = "order_id", unique = true)
	@JsonProperty("order_id")
	private int orderId;

	@Column(name = "customer_id")
	@JsonProperty("customer_id")
	private int customerId;

	@Enumerated(EnumType.STRING)
	@Column(name = "order_type")
	@NotNull
	@JsonProperty("order_type")
	private OrderType orderType;

	@Column(name = "order_date_time", nullable = false)
	@NotNull
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonProperty("order_date_time")
	private transient LocalDateTime dateAndTimeOrderMade = LocalDateTime.now();

	@Column(name = "order_status", nullable = false)
	@NotNull
	@JsonProperty("order_status")
	private boolean orderStatus = false;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
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

	public boolean isOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(boolean orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + ((dateAndTimeOrderMade == null) ? 0 : dateAndTimeOrderMade.hashCode());
		result = prime * result + ((orderDetails == null) ? 0 : orderDetails.hashCode());
		result = prime * result + orderId;
		result = prime * result + (orderStatus ? 1231 : 1237);
		result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId != other.customerId)
			return false;
		if (dateAndTimeOrderMade == null) {
			if (other.dateAndTimeOrderMade != null)
				return false;
		} else if (!dateAndTimeOrderMade.equals(other.dateAndTimeOrderMade))
			return false;
		if (orderDetails == null) {
			if (other.orderDetails != null)
				return false;
		} else if (!orderDetails.equals(other.orderDetails))
			return false;
		if (orderId != other.orderId)
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (orderType != other.orderType)
			return false;
		return true;
	}

}
