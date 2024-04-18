package com.project.sales.repository;

import com.project.sales.model.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Integer> {
}
