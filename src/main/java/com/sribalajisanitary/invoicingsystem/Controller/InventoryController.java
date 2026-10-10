package com.sribalajisanitary.invoicingsystem.Controller;

import com.sribalajisanitary.invoicingsystem.Service.StockInventoryService;
import com.sribalajisanitary.invoicingsystem.model.StockInventory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://192.168.0.111:3000"
})
public class InventoryController {
    private final StockInventoryService service;

    public InventoryController(StockInventoryService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public StockInventory createStock(@RequestBody StockInventory stock) {
        return service.saveStock(stock);
    }

    // READ - all
    @GetMapping
    public List<StockInventory> getAllStocks() {
        return service.getAllStocks();
    }

    // READ - by ID
    @GetMapping("/{id}")
    public StockInventory getStockById(@PathVariable Long id) {
        return service.getStockById(id);
    }

    // UPDATE - full update
    @PutMapping("/{id}")
    public StockInventory updateStock(@PathVariable Long id, @RequestBody StockInventory updatedStock) {
        return service.updateStock(id, updatedStock);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        service.deleteStock(id);
    }

    // SEARCH-AS-YOU-TYPE (by name or ID prefix)
    @GetMapping("/search")
    public List<StockInventory> searchStocks(@RequestParam String query) {
        return service.searchByNameOrIdPrefix(query);
    }

    // UPDATE PRICE (MRP or Buy Price)
    @PatchMapping("/{id}/price")
    public StockInventory updatePrice(@PathVariable Long id,
                                      @RequestParam(required = false) Double mrp,
                                      @RequestParam(required = false) Double buyPrice) {
        return service.updatePrice(id, mrp, buyPrice);
    }

    // UPDATE QUANTITY (e.g., after invoicing)
    @PatchMapping("/{id}/quantity")
    public StockInventory updateQuantity(@PathVariable Long id,
                                         @RequestParam int quantityChange) {
        return service.updateQuantity(id, quantityChange);
    }

}

