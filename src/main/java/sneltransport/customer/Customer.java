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
	 * Version ID of Customer class
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", unique = true)
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerCity == null) ? 0 : customerCity.hashCode());
		result = prime * result + ((customerFaxNumber == null) ? 0 : customerFaxNumber.hashCode());
		result = prime * result + ((customerHousenumber == null) ? 0 : customerHousenumber.hashCode());
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPostcode == null) ? 0 : customerPostcode.hashCode());
		result = prime * result + ((customerStreet == null) ? 0 : customerStreet.hashCode());
		result = prime * result + ((customerTelNumber == null) ? 0 : customerTelNumber.hashCode());
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
		Customer other = (Customer) obj;
		if (customerCity == null) {
			if (other.customerCity != null)
				return false;
		} else if (!customerCity.equals(other.customerCity))
			return false;
		if (customerFaxNumber == null) {
			if (other.customerFaxNumber != null)
				return false;
		} else if (!customerFaxNumber.equals(other.customerFaxNumber))
			return false;
		if (customerHousenumber == null) {
			if (other.customerHousenumber != null)
				return false;
		} else if (!customerHousenumber.equals(other.customerHousenumber))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPostcode == null) {
			if (other.customerPostcode != null)
				return false;
		} else if (!customerPostcode.equals(other.customerPostcode))
			return false;
		if (customerStreet == null) {
			if (other.customerStreet != null)
				return false;
		} else if (!customerStreet.equals(other.customerStreet))
			return false;
		if (customerTelNumber == null) {
			if (other.customerTelNumber != null)
				return false;
		} else if (!customerTelNumber.equals(other.customerTelNumber))
			return false;
		return true;
	}
}
