package com.billing.repository;

import com.billing.entity.Invoice;
import com.billing.entity.InvoiceItem;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {
    private List<Invoice> invoiceList = new ArrayList<>();

    public Invoice addInvoice(Invoice invoice){
        invoiceList.add(invoice);
        return invoiceList.get(invoice.getInvoiceId());
    }

    public Invoice findbyid(int id){
        return invoiceList.stream().filter(i -> i.getInvoiceId() == id).findFirst().orElseThrow(() ->  new RuntimeException("Invoice Not Found"));
    }

//    public Invoice updateRepository(Invoice invoice){
//        Invoice existing = findbyid(invoice.getInvoiceId());
//        if(existing != null){
//            existing.setInvoiceId(invoice.getInvoiceId());
//            existing.setInvoiceDate(invoice.getInvoiceDate());
//            existing.setCustomer(invoice.getCustomer());
//            existing.setTotalAmount(invoice.getTotalAmount());
//        }
//    }
}
