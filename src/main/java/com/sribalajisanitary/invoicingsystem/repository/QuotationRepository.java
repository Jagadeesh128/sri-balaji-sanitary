package com.sribalajisanitary.invoicingsystem.repository;

import com.sribalajisanitary.invoicingsystem.model.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
