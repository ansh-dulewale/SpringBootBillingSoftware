package com.billing.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {
    private int InvoiceId;
    private LocalDateTime invoiceDate;
    private Customer customer;
    private int totalAmount;
    private int totalTax;
    private int discount;
    private int finalAmount;

    public Invoice(int invoiceId, LocalDateTime invoiceDate, Customer customer, int totalAmount, int totalTax, int discount, int finalAmount) {
        InvoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customer = customer;
        this.totalAmount = totalAmount;
        this.totalTax = totalTax;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    public Invoice(){}

    public int getInvoiceId() {
        return InvoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        InvoiceId = invoiceId;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(int totalTax) {
        this.totalTax = totalTax;
    }

    public int getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(int finalAmount) {
        this.finalAmount = finalAmount;
    }
}
