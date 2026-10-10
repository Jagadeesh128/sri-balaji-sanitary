package com.sribalajisanitary.invoicingsystem.Controller;

import com.sribalajisanitary.invoicingsystem.model.StockInventory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quotations")
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://192.168.0.111:3000"
})
public class QuotationsController {
    @PostMapping
    public StockInventory saveQuotation(@RequestBody StockInventory stock) {
        StockInventory si = new StockInventory();
        si=stock;
        return si;
    }

}
