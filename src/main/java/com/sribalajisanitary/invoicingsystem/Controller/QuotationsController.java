package com.sribalajisanitary.invoicingsystem.Controller;

import com.sribalajisanitary.invoicingsystem.Service.QuotationsService;
import com.sribalajisanitary.invoicingsystem.model.Quotation;
import com.sribalajisanitary.invoicingsystem.model.QuotationProduct;
import com.sribalajisanitary.invoicingsystem.model.StockInventory;
import com.sribalajisanitary.invoicingsystem.repository.QuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotations")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://192.168.0.111:3000"
})
public class QuotationsController {
    @Autowired
    private QuotationsService quotationsService;

    @PostMapping
    public Quotation createQuotation(@RequestBody Quotation quotation) {
        return quotationsService.saveQuotation(quotation);
    }

    @GetMapping
    public List<Quotation> getAllQuotations() {
        return quotationsService.fetchQuotations();
    }

    @GetMapping("/{id}")
    public Quotation getQuotation(@PathVariable String id) {
        Long quotationId = Long.parseLong(id);
        return quotationsService.fetchQuotation(quotationId);
    }

    @PutMapping("/{id}")
    public Quotation updateQuotation(@RequestBody Quotation quotation, @PathVariable String id) {
        Long quotationId = Long.parseLong(id);
        return quotationsService.updateQuotation(quotationId,quotation);
    }


}
