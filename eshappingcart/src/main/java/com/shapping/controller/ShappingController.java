package com.shapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shapping.model.Customer;
import com.shapping.model.Product;
import com.shapping.model.Purchase;
import com.shapping.service.ShappingService;

@RestController
@RequestMapping("/api/eshapping")
public class ShappingController {
	
	
	@Autowired
	ShappingService shoppingservice;
	
	
	@GetMapping
	public String getMessage() {
	return "Online Electronics shopping portalt";
	}
	
	
	@PostMapping
	public  ResponseEntity<Customer> CreateOrUpdatee(Customer customer) {
		
		Customer createcust=shoppingservice.CreateOrUpdateCustomer(customer);
		
		return new ResponseEntity<Customer>(createcust, HttpStatus.OK);
	}
	
	@PutMapping
	public  ResponseEntity<Customer> updateCustomer(Customer customer)  throws Exception {
		
		Customer createcust=shoppingservice.updatecustomer(customer);
		
		return new ResponseEntity<Customer>(createcust, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addproduct/{cid}")
	public ResponseEntity<Product> addproduct(Product product,@PathVariable("cid")long cid) throws Exception{
		
		Product addprod=shoppingservice.addproduct(product,cid);
		
		return new ResponseEntity<Product>(addprod,HttpStatus.OK);
		
	}
	
	@PostMapping("/orderproduct")
	public ResponseEntity<Purchase> orderproduct(Purchase purchase) throws Exception {
		
		Purchase order=shoppingservice.orderproduct(purchase);
		
		return new ResponseEntity<Purchase>(order,HttpStatus.OK);
	}
}
