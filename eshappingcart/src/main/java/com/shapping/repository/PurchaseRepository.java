package com.shapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shapping.model.Purchase;


@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
