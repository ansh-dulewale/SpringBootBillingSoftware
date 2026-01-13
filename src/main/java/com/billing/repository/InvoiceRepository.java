//package com.billing.repository;
//
//import com.billing.entity.Customer;
//import com.billing.entity.Invoice;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class InvoiceRepository {
//
//    private final List<Invoice> list = new ArrayList<>();
//
//    public Invoice createInvoice(Invoice invoice) {
//        list.add(invoice);
//        return invoice;
//    }
//
//    public Invoice getInvoiceById(int orderId) {
//        for (Invoice invoice : list) {
//            if (orderId == invoice.getInvoiceId()) {
//                return invoice;
//            }
//        }
//        return null;
//    }
//
//    public List<Invoice> getAllInvoice() {
//        return list;
//    }
//
//    public List<Invoice> getbyCustomerId(int id){
//        return list.stream().filter(i -> i.getCustomer().getId() == id).toList();
//    }
//}
