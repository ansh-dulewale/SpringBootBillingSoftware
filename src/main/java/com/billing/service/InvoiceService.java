    package com.billing.service;

    import com.billing.dto.InvoiceRequestDTO;
    import com.billing.entity.Invoice;

    import java.util.List;

    public interface InvoiceService {
        Invoice createInvoice(InvoiceRequestDTO invoiceRequestDTO);
        Invoice getInvoiceByid(int id);
        List<Invoice> getAllInvoices();
        List<Invoice> getInvoicesByCustomer(int cutomerId);
    }
