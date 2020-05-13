package com.shapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shapping.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
