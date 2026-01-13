package com.billing.dao;

import com.billing.entity.InvoiceItem;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvoiceItemDaoImpl implements InvoiceDaoInterface{

    private final JdbcTemplate jdbcTemplate;

    public InvoiceItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveAll(List<InvoiceItem> items, int invoiceId) {

        String sql = """
            INSERT INTO invoice_item
            (invoice_id, product_id, quantity, price, tax_amount, total)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        for (InvoiceItem item : items) {
            jdbcTemplate.update(
                    sql,
                    invoiceId,
                    item.getProduct().getProductId(),
                    item.getQuantity(),
                    item.getPrice(),
                    item.getTaxAmount(),
                    item.getTotal()
            );
        }
    }

    @Override
    public List<InvoiceItem> findByInvoiceId(int invoiceId) {

        String sql = "SELECT * FROM invoice_item WHERE invoice_id = ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(InvoiceItem.class),
                invoiceId
        );
    }
}
