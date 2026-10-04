package com.sribalajisanitary.invoicingsystem.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stock_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockInventory {

    @Id
    private String productId;

    @Column(nullable = false)
    private String productName;

    private int quantity;

    private double mrp;

    private String make;

    private double buyPrice;

    private String remarks;
}
