package com.sribalajisanitary.invoicingsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Discount_Categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCategories {
    @Id
    private String brand;
    private String buyDiscount;
    private String category_A;
    private String category_B;
    private String category_C;
    private String category_D;
    private String category_E;
    private String remarks;
}
