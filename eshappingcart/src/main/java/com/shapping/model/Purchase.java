package com.shapping.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "transid")
	@SequenceGenerator(name="transid",sequenceName = "transid",allocationSize = 12)
	@Column(name="transid",updatable = false)
	private long id;
	
	private long prodid;
	
	private String pname;
	
	private Double price;
	
	private long custid;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProdid() {
		return prodid;
	}

	public void setProdid(long prodid) {
		this.prodid = prodid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	
	}