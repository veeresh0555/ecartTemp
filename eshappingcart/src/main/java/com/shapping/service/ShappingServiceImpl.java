package com.shapping.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.shapping.model.Customer;
import com.shapping.model.Product;
import com.shapping.model.Purchase;
import com.shapping.repository.CustomerRepository;
import com.shapping.repository.ProductRepository;
import com.shapping.repository.PurchaseRepository;

@Service
@Transactional
public class ShappingServiceImpl implements ShappingService {

	@Autowired
	CustomerRepository custRepository;

	@Autowired
	PurchaseRepository OnlineshoppingPurchase;
	
	@Autowired
	ProductRepository prepository;

	@Override
	public Customer CreateOrUpdateCustomer(Customer customer) {

		
		return custRepository.save(customer);
	}

	@Override
	public Product Addtocart(Product Productrequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> getitems(long productid, String quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addproduct(Product product,long cid) throws Exception {
		
		Optional<Customer> checkcust=custRepository.findById(cid);
		if(checkcust.isPresent()) {
			//Customer getcust=checkcust.get();
			//List<Product> prodList=getcust.getproductid();
			//prodList.stream().forEach(lst->lst.get);
			
			return product=prepository.save(product);
			
		}else {
			
			//System.out.println("CID/Customer not Available ! please Register");
			
			throw new Exception("Customer Id Not Available");
		}
	}

	@Override
	public Purchase orderproduct(Purchase purchase) throws Exception {
		Optional<Customer> checkcust=custRepository.findById(purchase.getCustid());
		if(checkcust.isPresent()) {
			Optional<Product> checkprod=prepository.findById(purchase.getProdid());
			if(checkprod.isPresent()) {
				Customer cust=checkcust.get();
				Product product=checkprod.get();
				purchase.setPname(product.getProductName());
				purchase.setPrice(product.getPrice());
				purchase.setCustid(cust.getCustid());
				
				
				
				
				return OnlineshoppingPurchase.save(purchase);
			}else {
				System.out.println("Product Not available");
					throw new ClassNotFoundException("Product Not available");
			}
			}else {
			System.out.println("Cid Not found");
			throw new ClassNotFoundException("Customer Not available");
		}
		
	}

	@Override
	public Customer updatecustomer(Customer customer) throws Exception {
		Optional<Customer> checkcust=custRepository.findById(customer.getCustid());
		if(checkcust.isPresent()) {
			Customer newcust=checkcust.get();
			newcust.setCustid(customer.getCustid());
			newcust.setFirstname(customer.getFirstname());
			newcust.setLastname(customer.getLastname());
			newcust.setEmail(customer.getEmail());
			newcust.setMobile(customer.getMobile());
			//custRepository.deleteById(newcust.getCustid());
			return custRepository.save(newcust);
			
			
		}else {
			throw new Exception("Record Not Found");
			//return custRepository.save(customer);
		}
	}
			
}
