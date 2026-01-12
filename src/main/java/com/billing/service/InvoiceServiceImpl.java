package com.billing.service;

import com.billing.entity.Invoice;
import com.billing.dto.InvoiceRequestDTO;
import com.billing.entity.InvoiceItem;
import com.billing.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    InvoiceRepository ir = new InvoiceRepository();
    @Override
    public Invoice createInvoice(InvoiceRequestDTO invoiceRequestDTO) {

        int count = 1;
        Invoice invoice = new Invoice();
        for(InvoiceItem item : invoiceRequestDTO.getItems()){
            item.setPrice(item.getProduct().getPrice() * item.getProduct().getStockQuantity());
            item.setTaxAmount((int) ( item.getPrice() *  0.18));
            item.setTotal(item.getPrice() + item.getTaxAmount());
            invoice.setTotalAmount(invoice.getTotalAmount() + item.getPrice());
            invoice.setTotalTax(item.getTaxAmount());
        }
        invoice.setFinalAmount(invoice.getTotalAmount() + invoice.getTotalTax() - invoice.getDiscount());
        return invoice;
    }


    @Override
    public Invoice getInvoiceByid(int id) {
        return ir.getInvoiceById(id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return ir.getAllInvoice();
    }

    @Override
    public List<Invoice> getInvoicesByCustomer(int cutomerId) {
        return ir.getbyCustomerId(cutomerId);
    }

}
