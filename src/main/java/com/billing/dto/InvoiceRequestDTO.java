package com.billing.dto;
import com.billing.entity.Customer;
import com.billing.entity.InvoiceItem;
import com.billing.entity.Product;
import com.billing.repository.ProductRepository;

import java.util.List;

public class InvoiceRequestDTO {
    private Customer customer;
    private List<InvoiceItem> items;
    private int discount;

    public int customerId(Customer customer){
        return customer.getId();
    }

    public void setCustomerId(Customer cust){
        customer.setId(cust.getId());
    }

    public List<InvoiceItem> getItems(){
        return items;
    }
}
