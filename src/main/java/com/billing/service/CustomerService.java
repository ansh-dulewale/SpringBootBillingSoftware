package com.billing.service;

import com.billing.entity.Customer;
import com.billing.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.billing.service.CustSer;
import java.util.List;

@Service
public class CustomerService implements CustSer{

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer addService(Customer customer) {
        return repository.add(customer);
    }

    @Override
    public Customer updateService(int id, Customer customer) {
        return repository.update(id, customer);
    }

    @Override
    public Customer getByIdService(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Customer> getAllService() {
        return repository.findAll();
    }
}

