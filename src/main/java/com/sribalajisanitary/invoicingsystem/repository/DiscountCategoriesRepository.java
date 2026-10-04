package com.sribalajisanitary.invoicingsystem.repository;

import com.sribalajisanitary.invoicingsystem.model.DiscountCategories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountCategoriesRepository extends JpaRepository<DiscountCategories, String> {
}