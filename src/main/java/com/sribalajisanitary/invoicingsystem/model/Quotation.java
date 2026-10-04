package com.sribalajisanitary.invoicingsystem.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "quotation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quotation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quotationNo;   // Auto-generated quotation number

    @Column(nullable = false)
    private String customerName;

    @Column(nullable = false)
    private String contactNo;

    // One quotation can have many products
    @OneToMany(mappedBy = "quotation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<QuotationProduct> products;
}

