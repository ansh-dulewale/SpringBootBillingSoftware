package com.billing.dao;

import com.billing.entity.InvoiceItem;
import java.util.List;

public interface InvoiceDaoInterface {

    void saveAll(List<InvoiceItem> items, int invoiceId);

    List<InvoiceItem> findByInvoiceId(int invoiceId);
}
