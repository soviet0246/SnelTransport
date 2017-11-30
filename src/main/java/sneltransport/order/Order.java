package sneltransport.order;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters.LocalDateTimeConverter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import ch.qos.logback.core.subst.Token.Type;

@Entity
@Table(name = "order")
public class Order implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", nullable = false, unique = true)
	@NotNull
	private int orderId;

	@Enumerated(EnumType.STRING)
	@Column(name="orderType")
	@NotNull
	private OrderType orderType;

	// private CustomerId Auto linken
	@Column(name="dateAndTimeOfOrderMade", nullable = false)
	@NotNull
	@JsonSerialize(using = LocalDateTimeSerializer.class)
//	@Temporal(value = TemporalType.TIMESTAMP)
	private LocalDateTime dateAndTimeOfOrderMade = LocalDateTime.now();

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public LocalDateTime getDateAndTimeOfOrderMade() {
		return dateAndTimeOfOrderMade;
	}

	public void setDateAndTimeOfOrderMade(LocalDateTime dateAndTimeOfOrderMade) {
		this.dateAndTimeOfOrderMade = dateAndTimeOfOrderMade;
	}
	
	
	
}
