package com.billing.repository;
import com.billing.entity.Customer;
import com.billing.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    List<Customer> customers = new ArrayList<>();

    public Customer add(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public Customer findByid(int id){
        return customers.stream().filter(c -> c.getId() == id).findFirst().orElseThrow(() -> new ResourceNotFoundException("Not Found"));
    }

    public Customer updatedetail(Customer customer){
        Customer existing = findByid(customer.getId());
        if(existing != null){
            existing.setId(customer.getId());
            existing.setName(customer.getName());
            existing.setPhone(customer.getPhone());
            existing.setEmail(customer.getEmail());
            existing.setAddress(customer.getAddress());

        }else{
            throw new ResourceNotFoundException("Customer Not Found");
        }
        return existing;
    }

    public List<Customer> findAll(){
        return customers;
    }

}
