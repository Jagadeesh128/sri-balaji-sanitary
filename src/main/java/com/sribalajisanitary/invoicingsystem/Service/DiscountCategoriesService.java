package com.sribalajisanitary.invoicingsystem.Service;

import com.sribalajisanitary.invoicingsystem.model.DiscountCategories;
import com.sribalajisanitary.invoicingsystem.repository.DiscountCategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountCategoriesService {

    private final DiscountCategoriesRepository repository;

    public DiscountCategoriesService(DiscountCategoriesRepository repository) {
        this.repository = repository;
    }

    // CREATE or UPDATE
    public DiscountCategories saveDiscountCategory(DiscountCategories category) {
        return repository.save(category);
    }

    // READ all
    public List<DiscountCategories> getAllCategories() {
        return repository.findAll();
    }

    // READ by brand
    public DiscountCategories getCategoryByBrand(String brand) {
        return repository.findById(brand).orElse(null);
    }

    // DELETE
    public void deleteCategory(String brand) {
        repository.deleteById(brand);
    }
}
