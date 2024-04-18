package com.project.sales.repository;

import com.project.sales.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
}
