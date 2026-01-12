package com.billing.dto;
import com.billing.entity.Customer;
import com.billing.entity.Invoice;
import com.billing.entity.InvoiceItem;

import java.util.List;

public class InvoiceRequestDTO {
    private Customer customer;
    private List<InvoiceItem> items;
    private int discount;

    public List<InvoiceItem> getItems() {
        return items;
    }

    public void setItems(List<InvoiceItem> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int customerId(Customer customer){
        return customer.getId();
    }


}
