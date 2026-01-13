package com.billing.controller;

import com.billing.dto.InvoiceRequestDTO;
import com.billing.entity.Customer;
import com.billing.entity.Invoice;
import com.billing.service.InvoiceService;
import com.billing.service.InvoiceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(
            @RequestBody InvoiceRequestDTO invoiceRequestDTO) {

        return new ResponseEntity<>(
                service.createInvoice(invoiceRequestDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getInvoice() {
        return ResponseEntity.ok(service.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id) {
        return ResponseEntity.ok(service.getInvoiceByid(id));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<List<Invoice>> getByCustomer(@PathVariable int id) {
        return ResponseEntity.ok(service.getInvoicesByCustomer(id));
    }
}

