package com.billing.dao;

import com.billing.entity.Invoice;
import java.util.List;

public interface InvoiceDao {

    Invoice save(Invoice invoice);

    Invoice findById(int invoiceId);

    List<Invoice> findAll();

    List<Invoice> findByCustomerId(int customerId);
}
