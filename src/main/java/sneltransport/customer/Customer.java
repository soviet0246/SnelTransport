package sneltransport.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Customer")
public class Customer implements Serializable {

	/**
	 * Version ID of Order class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", nullable = false, unique = true)
	@NotNull
	@JsonProperty("customer_id")
	private int customerId;

	@Column(name = "customer_name", nullable = false)
	@NotNull
	@JsonProperty("customer_name")
	private String customerName;

	@Column(name = "customer_street", nullable = false)
	@NotNull
	@JsonProperty("customer_street")
	private String customerStreet;

	@Column(name = "customer_housenumber", nullable = false)
	@NotNull
	@JsonProperty("customer_housenumber")
	private String customerHousenumber;

	@Column(name = "customer_postcode", nullable = false)
	@NotNull
	@JsonProperty("customer_postcode")
	private String customerPostcode;

	@Column(name = "customer_city", nullable = false)
	@NotNull
	@JsonProperty("customer_city")
	private String customerCity;

	@Column(name = "customer_tel_number", nullable = false)
	@NotNull
	@JsonProperty("customer_tel_number")
	private String customerTelNumber;

	@Column(name = "customer_fax_number")
	@JsonProperty("customer_fax_number")
	private String customerFaxNumber;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public String getCustomerHousenumber() {
		return customerHousenumber;
	}

	public void setCustomerHousenumber(String customerHousenumber) {
		this.customerHousenumber = customerHousenumber;
	}

	public String getCustomerPostcode() {
		return customerPostcode;
	}

	public void setCustomerPostcode(String customerPostcode) {
		this.customerPostcode = customerPostcode;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerTelNumber() {
		return customerTelNumber;
	}

	public void setCustomerTelNumber(String customerTelNumber) {
		this.customerTelNumber = customerTelNumber;
	}

	public String getCustomerFaxNumber() {
		return customerFaxNumber;
	}

	public void setCustomerFaxNumber(String customerFaxNumber) {
		this.customerFaxNumber = customerFaxNumber;
	}
}
