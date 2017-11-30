//package sneltransport.articles;
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
//@Table(name = "article")
//public class Article implements Serializable {
//
//	/**
//	 * Version ID of Order class
//	 */
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "articleId", nullable = false, unique = true)
//	@NotNull
//	private int articleId;
//
////	@Enumerated(EnumType.STRING)
//	@Column(name="articleName")
//	@NotNull
//	private String articleName;
//
//	@Column(name="articlePrice")
//	private Double articlePrice;
//	
//	@Column(name="articleSomething")
//	@NotNull
//	private String articleSomething;
//	
//	@Column(name="articleType")
//	private String articleType;
//	
//	@Column(name="articleColor")
//	@Enumerated(EnumType.STRING)
//	private String articleColor;
//	
//	
//	
//	// private CustomerId Auto linken
////	@Column(name="dateAndTimeOfOrderMade", nullable = false)
////	@NotNull
////	@JsonSerialize(using = LocalDateTimeSerializer.class)
//////	@Temporal(value = TemporalType.TIMESTAMP)
////	private LocalDateTime dateAndTimeOfOrderMade = LocalDateTime.now();
//
//	
//	
//	
//	
//}
