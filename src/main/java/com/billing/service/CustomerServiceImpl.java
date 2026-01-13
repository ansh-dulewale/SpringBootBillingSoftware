package com.billing.service;

import com.billing.entity.Customer;
import org.springframework.stereotype.Service;
import com.billing.service.CustSer;
import java.util.List;
import com.billing.dao.CustomerDao;

@Service
public class CustomerServiceImpl implements CustSer {

    private final CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public Customer addService(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer getByIdService(int id) {
        return customerDao.findById(id);
    }

    @Override
    public List<Customer> getAllService() {
        return customerDao.findAll();
    }

    @Override
    public Customer updateService(int id, Customer customer) {
        return customerDao.update(id, customer);
    }
}


