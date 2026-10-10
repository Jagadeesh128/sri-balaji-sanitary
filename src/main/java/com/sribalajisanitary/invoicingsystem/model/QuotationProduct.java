package com.sribalajisanitary.invoicingsystem.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "quotation_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuotationProduct {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String productId;
        private String productName;
        private double mrp;
        private String make;
        private double discount;
        private int quantity;
        private double finalPrice;
    }


