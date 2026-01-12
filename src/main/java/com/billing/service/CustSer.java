package com.billing.service;
import com.billing.entity.Customer;
import java.util.List;

public interface CustSer {
    Customer addService(Customer customer);
    Customer updateService(int id, Customer customer);
    Customer getByIdService(int id);
    List<Customer> getAllService();
}

