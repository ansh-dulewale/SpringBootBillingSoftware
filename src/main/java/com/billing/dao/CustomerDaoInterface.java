package com.billing.dao;

import com.billing.entity.Customer;

import java.util.List;

public interface CustomerDaoInterface {

    Customer save(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();

    Customer update(int id, Customer customer);

    void deleteById(int id);
}
