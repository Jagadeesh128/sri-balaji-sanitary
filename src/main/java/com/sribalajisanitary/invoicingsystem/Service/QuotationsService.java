package com.sribalajisanitary.invoicingsystem.Service;

import com.sribalajisanitary.invoicingsystem.model.Quotation;
import com.sribalajisanitary.invoicingsystem.model.QuotationProduct;
import com.sribalajisanitary.invoicingsystem.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationsService {
    @Autowired
    private QuotationRepository quotationRepository;

    public Quotation saveQuotation(Quotation quotation) {
        // Ensure each product points back to the parent quotation

        return quotationRepository.save(quotation);
    }
}
