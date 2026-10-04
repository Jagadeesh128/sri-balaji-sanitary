package com.sribalajisanitary.invoicingsystem.repository;

import com.sribalajisanitary.invoicingsystem.model.StockInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockInventoryRepository extends JpaRepository<StockInventory, Long> {
    List<StockInventory> findByProductNameContainingIgnoreCaseOrProductIdStartingWith(String name, String idPrefix);
}
