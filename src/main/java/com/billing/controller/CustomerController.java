package com.billing.controller;

import com.billing.entity.Customer;
import com.billing.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    // POST /customer
    @PostMapping
    public ResponseEntity<Customer> createCustomer(
            @RequestBody Customer customer) {

        return new ResponseEntity<>(
                service.addService(customer),
                HttpStatus.CREATED
        );
    }

    // PUT /customer/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable int id,
            @RequestBody Customer customer) {

        return ResponseEntity.ok(
                service.updateService(id, customer)
        );
    }

    // GET /customer
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllService());
    }

    // GET /customer/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable int id) {

        return ResponseEntity.ok(service.getByIdService(id));
    }
}

