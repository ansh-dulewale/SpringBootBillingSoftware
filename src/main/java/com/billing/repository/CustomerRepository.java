//package com.billing.repository;
//import com.billing.entity.Customer;
//import com.billing.exception.ResourceNotFoundException;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class CustomerRepository {
//
//    private final List<Customer> customers = new ArrayList<>();
//
//    public Customer add(Customer customer) {
//        customers.add(customer);
//        return customer;
//    }
//
//    public Customer findById(int id) {
//        return customers.stream()
//                .filter(c -> c.getId() == id)
//                .findFirst()
//                .orElseThrow(() ->
//                        new ResourceNotFoundException("Customer not found"));
//    }
//
//    public Customer update(int id, Customer customer) {
//        Customer existing = findById(id);
//
//        existing.setName(customer.getName());
//        existing.setPhone(customer.getPhone());
//        existing.setEmail(customer.getEmail());
//        existing.setAddress(customer.getAddress());
//
//        return existing;
//    }
//
//    public List<Customer> findAll() {
//        return customers;
//    }
//}
//
