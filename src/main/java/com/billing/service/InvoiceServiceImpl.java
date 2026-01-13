package com.billing.service;

import com.billing.dao.InvoiceDao;
import com.billing.dao.InvoiceItemDaoImpl;
import com.billing.entity.Invoice;
import com.billing.dto.InvoiceRequestDTO;
import com.billing.entity.InvoiceItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceDao invoiceDao;
    private final InvoiceItemDaoImpl InvoiceItemDao;

    public InvoiceServiceImpl(
            InvoiceDao invoiceDao, InvoiceItemDaoImpl invoiceItemDao1) {
        this.invoiceDao = invoiceDao;
        InvoiceItemDao = invoiceItemDao1;
    }

    @Override
    public Invoice createInvoice(InvoiceRequestDTO dto) {

        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setCustomer(dto.getCustomer());
        invoice.setDiscount(dto.getDiscount());

        int totalAmount = 0;
        int totalTax = 0;

        for (InvoiceItem item : dto.getItems()) {
            int price = item.getProduct().getPrice() * item.getQuantity();
            int tax = (int) (price * 0.18);

            item.setPrice(price);
            item.setTaxAmount(tax);
            item.setTotal(price + tax);

            totalAmount += price;
            totalTax += tax;
        }

        invoice.setTotalAmount(totalAmount);
        invoice.setTotalTax(totalTax);
        invoice.setFinalAmount(totalAmount + totalTax - invoice.getDiscount());

        invoiceDao.save(invoice);

        for (InvoiceItem item : dto.getItems()) {
            item.setInvoiceId(invoice.getInvoiceId());
        }

        InvoiceItemDao.saveAll(dto.getItems(), invoice.getInvoiceId());

        return invoice;
    }

    @Override
    public Invoice getInvoiceByid(int id) {
        return invoiceDao.findById(id);
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceDao.findAll();
    }

    @Override
    public List<Invoice> getInvoicesByCustomer(int customerId) {
        return invoiceDao.findByCustomerId(customerId);
    }
}

