package sneltransport.customer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	private int customer_id;

	@Column(name = "customer_name", nullable = false)
	@NotNull
	private String customer_name;

	@Column(name = "customer_street", nullable = false)
	@NotNull
	private String customer_street;

	@Column(name = "customer_housenumber", nullable = false)
	@NotNull
	private String customer_housenumber;

	@Column(name = "customer_postcode", nullable = false)
	@NotNull
	private String customer_postcode;

	@Column(name = "customer_city", nullable = false)
	@NotNull
	private String customer_city;

	@Column(name = "customer_tel_number", nullable = false)
	@NotNull
	private String customer_tel_number;

	@Column(name = "customer_fax_number")
	private String customer_fax_number;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_street() {
		return customer_street;
	}

	public void setCustomer_street(String customer_street) {
		this.customer_street = customer_street;
	}

	public String getCustomer_housenumber() {
		return customer_housenumber;
	}

	public void setCustomer_housenumber(String customer_housenumber) {
		this.customer_housenumber = customer_housenumber;
	}

	public String getCustomer_postcode() {
		return customer_postcode;
	}

	public void setCustomer_postcode(String customer_postcode) {
		this.customer_postcode = customer_postcode;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	public String getCustomer_tel_number() {
		return customer_tel_number;
	}

	public void setCustomer_tel_number(String customer_tel_number) {
		this.customer_tel_number = customer_tel_number;
	}

	public String getCustomer_fax_number() {
		return customer_fax_number;
	}

	public void setCustomer_fax_number(String customer_fax_number) {
		this.customer_fax_number = customer_fax_number;
	}

}
