package com.shapping.service;

import java.util.List;

import com.shapping.model.Customer;
import com.shapping.model.Product;
import com.shapping.model.Purchase;

public interface ShappingService {

	public Customer CreateOrUpdateCustomer(Customer customer);

	public Product Addtocart(Product Productrequest);

	public List<Purchase> getitems(long productid, String quantity);

	public Product addproduct(Product product,long cid) throws Exception ;

	public Purchase orderproduct(Purchase purchase) throws Exception;

	public Customer updatecustomer(Customer customer)  throws Exception;
	
	
	
}
