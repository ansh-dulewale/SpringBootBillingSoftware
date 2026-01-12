package com.billing.service;

import com.billing.entity.Customer;
import com.billing.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository cr = new CustomerRepository();
    public Customer addService(Customer customer){
        return cr.add(customer);
    }

    public Customer updateService(Customer customer){
        return cr.updatedetail(customer);
    }

    public List<Customer> getAllService(){
        return cr.findAll();
    }

    public Customer getByIdService(int id){
        return cr.findByid(id);
    }
}
