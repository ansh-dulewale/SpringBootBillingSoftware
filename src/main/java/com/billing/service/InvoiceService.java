package com.billing.service;
import com.billing.entity.Customer;
import com.billing.entity.Invoice;
import com.billing.entity.InvoiceItem;
import com.billing.repository.CustomerRepository;
import com.billing.repository.ProductRepository;

public class InvoiceService {
    ProductRepository pr = new ProductRepository();
    public Customer getIdService(int id){
        return customers.get(id);
    }
}
