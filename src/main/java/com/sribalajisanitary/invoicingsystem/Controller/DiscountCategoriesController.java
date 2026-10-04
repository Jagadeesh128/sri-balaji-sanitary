package com.sribalajisanitary.invoicingsystem.Controller;

import com.sribalajisanitary.invoicingsystem.model.DiscountCategories;
import com.sribalajisanitary.invoicingsystem.Service.DiscountCategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discounts")
@CrossOrigin(origins = "http://localhost:3000")  // allow React dev server
public class DiscountCategoriesController {

    private final DiscountCategoriesService service;

    public DiscountCategoriesController(DiscountCategoriesService service) {
        this.service = service;
    }

    // CREATE or UPDATE
    @PostMapping
    public DiscountCategories createOrUpdateCategory(@RequestBody DiscountCategories category) {
        return service.saveDiscountCategory(category);
    }

    // READ all
    @GetMapping
    public List<DiscountCategories> getAllCategories() {
        return service.getAllCategories();
    }

    // READ by brand
    @GetMapping("/{brand}")
    public DiscountCategories getCategoryByBrand(@PathVariable String brand) {
        return service.getCategoryByBrand(brand);
    }

    // DELETE
    @DeleteMapping("/{brand}")
    public void deleteCategory(@PathVariable String brand) {
        service.deleteCategory(brand);
    }
}
