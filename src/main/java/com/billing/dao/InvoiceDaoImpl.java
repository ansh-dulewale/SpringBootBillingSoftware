package com.billing.dao;
import com.billing.entity.Customer;
import com.billing.entity.Invoice;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class InvoiceDaoImpl implements InvoiceDao {

    private final JdbcTemplate jdbcTemplate;

    public InvoiceDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Invoice save(Invoice invoice) {

        String sql = """
            INSERT INTO invoice 
            (invoice_date, customer_id, total_amount, total_tax, discount, final_amount)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        jdbcTemplate.update(
                sql,
                invoice.getInvoiceDate(),
                invoice.getCustomer().getId(),
                invoice.getTotalAmount(),
                invoice.getTotalTax(),
                invoice.getDiscount(),
                invoice.getFinalAmount()
        );

        return invoice;
    }

    @Override
    public Invoice findById(int invoiceId) {

        String sql = "SELECT * FROM invoice WHERE invoice_id = ?";

        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Invoice.class),
                invoiceId
        );
    }

    @Override
    public List<Invoice> findAll() {

        String sql = "SELECT * FROM invoice";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Invoice.class)
        );
    }

    @Override
    public List<Invoice> findByCustomerId(int customerId) {

        String sql = "SELECT * FROM invoice WHERE customer_id = ?";

        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Invoice.class),
                customerId
        );
    }
}
