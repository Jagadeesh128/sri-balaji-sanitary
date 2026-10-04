package com.sribalajisanitary.invoicingsystem.Service;

import com.sribalajisanitary.invoicingsystem.model.StockInventory;
import com.sribalajisanitary.invoicingsystem.repository.StockInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockInventoryService {

    private final StockInventoryRepository repository;

    public StockInventoryService(StockInventoryRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public StockInventory saveStock(StockInventory stock) {
        return repository.save(stock);
    }

    // READ - all
    public List<StockInventory> getAllStocks() {
        return repository.findAll();
    }

    // READ - by ID
    public StockInventory getStockById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // UPDATE - full update
    public StockInventory updateStock(Long id, StockInventory updatedStock) {
        StockInventory existing = repository.findById(id).orElse(null);
        if (existing != null) {
            existing.setProductName(updatedStock.getProductName());
            existing.setQuantity(updatedStock.getQuantity());
            existing.setMrp(updatedStock.getMrp());
            existing.setMake(updatedStock.getMake());
            existing.setBuyPrice(updatedStock.getBuyPrice());
            existing.setRemarks(updatedStock.getRemarks());
            return repository.save(existing);
        }
        return null;
    }

    // DELETE
    public void deleteStock(Long id) {
        repository.deleteById(id);
    }

    // SEARCH-AS-YOU-TYPE
    public List<StockInventory> searchByNameOrIdPrefix(String query) {
        return repository.findByProductNameContainingIgnoreCaseOrProductIdStartingWith(query, query);
    }

    // UPDATE PRICE
    public StockInventory updatePrice(Long id, Double mrp, Double buyPrice) {
        StockInventory stock = repository.findById(id).orElse(null);
        if (stock != null) {
            if (mrp != null) stock.setMrp(mrp);
            if (buyPrice != null) stock.setBuyPrice(buyPrice);
            return repository.save(stock);
        }
        return null;
    }

    // UPDATE QUANTITY
    public StockInventory updateQuantity(Long id, int quantityChange) {
        StockInventory stock = repository.findById(id).orElse(null);
        if (stock != null) {
            stock.setQuantity(stock.getQuantity() + quantityChange);
            return repository.save(stock);
        }
        return null;
    }
}
