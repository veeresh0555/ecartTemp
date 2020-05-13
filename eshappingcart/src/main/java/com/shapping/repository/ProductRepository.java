package com.shapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shapping.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
