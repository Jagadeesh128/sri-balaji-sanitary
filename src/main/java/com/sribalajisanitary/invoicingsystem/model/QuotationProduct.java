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
    private Long serialNo;   // Serial number for each product line

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private String productName;

    private String make;

    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    // Link back to the quotation
    @ManyToOne
    @JoinColumn(name = "quotation_no")
    private Quotation quotation;
}
