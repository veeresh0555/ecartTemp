package com.shapping.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "custid")
	@SequenceGenerator(name="custid",sequenceName = "custseq",allocationSize = 12)
	@Column(name="custid",updatable = false)
	private long custid;

	public List<Product> getProductid() {
		return productid;
	}

	public void setProductid(List<Product> productid) {
		this.productid = productid;
	}

	private String firstname;

	private String lastname;

	private String email;

	private String mobile;

	@OneToMany(mappedBy = "cust", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Product> productid;

	public List<Product> getproductid() {
		return productid;
	}

	public void setAcnumber(List<Product> productid) {
		this.productid = productid;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}