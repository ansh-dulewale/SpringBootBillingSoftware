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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try{
            return new ResponseEntity<>(service.addService(customer), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, Customer customer){
        try{
            return new ResponseEntity<>(service.updateService(customer), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllController(){
            return ResponseEntity.ok(service.getAllService());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getbyIdController(@PathVariable int id){
        try{
            return ResponseEntity.ok(service.getByIdService(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
