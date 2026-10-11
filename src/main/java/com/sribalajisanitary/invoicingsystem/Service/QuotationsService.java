package com.sribalajisanitary.invoicingsystem.Service;

import com.sribalajisanitary.invoicingsystem.model.Quotation;
import com.sribalajisanitary.invoicingsystem.model.QuotationProduct;
import com.sribalajisanitary.invoicingsystem.repository.QuotationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@Service
public class QuotationsService {
    @Autowired
    private QuotationRepository quotationRepository;

    public Quotation saveQuotation(Quotation quotation) {
        // Ensure each product points back to the parent quotation

        return quotationRepository.save(quotation);
    }

    public List<Quotation> fetchQuotations() {
        return quotationRepository.findAll();
    }

    public Quotation fetchQuotation(Long id) {
        return  quotationRepository.findById(id).orElse(null);
    }

    @Transactional
    public Quotation updateQuotation(Long id, Quotation req) {
        req.setId(id);
        return quotationRepository.save(req);
    }
}
