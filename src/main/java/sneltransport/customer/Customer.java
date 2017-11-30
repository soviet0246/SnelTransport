//package sneltransport.customer;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
//
//import org.springframework.data.jpa.convert.threetenbp.ThreeTenBackPortJpaConverters.LocalDateTimeConverter;
//
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//
//import ch.qos.logback.core.subst.Token.Type;
//
//@Entity
//@Table(name = "customer")
//public class Customer implements Serializable {
//
//	/**
//	 * Version ID of Order class
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "customerId", nullable = false, unique = true)
//	@NotNull
//	private int customerId;
//
//	
//	private String customerName;
//	
//	private String customerStreet;
//	
//	private short customerHouseNumber;
//	
//	private String customerHouseNumberAddition;
//	
//	private String customerPostcode;
//	
//	private String customerCity;
//	
//	private String customerTelNumber;
//	
//	private String customerFaxNumber;
//	
//	
//	
//	//	@Enumerated(EnumType.STRING)
////	@Column(name = "orderType")
////	@NotNull
////	private OrderType orderType;
//
//	// private CustomerId Auto linken
////	@Column(name = "dateAndTimeOfOrderMade", nullable = false)
////	@NotNull
////	@JsonSerialize(using = LocalDateTimeSerializer.class)
////	// @Temporal(value = TemporalType.TIMESTAMP)
////	private LocalDateTime dateAndTimeOfOrderMade = LocalDateTime.now();
//}
