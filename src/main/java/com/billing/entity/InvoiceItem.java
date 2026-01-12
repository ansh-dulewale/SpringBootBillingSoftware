    package com.billing.entity;

    public class InvoiceItem {
        private Integer invoiceItemId;
        private Integer InvoiceId;
        private Product product;
        private int quantity;
        private int price;
        private int taxAmount;
        private int total;

        public InvoiceItem(int invoiceItemId, Product product, int quantity, int price, int taxAmount, int total) {
            this.invoiceItemId = invoiceItemId;
            this.product = product;
            this.quantity = quantity;
            this.price = price;
            this.taxAmount = taxAmount;
            this.total = total;
        }

        public InvoiceItem(){}
        public int getInvoiceItemId() {
            return invoiceItemId;
        }

        public void getInvoiceId(Invoice invoice){
            Invoice in = new Invoice();
            this.InvoiceId = in.getInvoiceId();
        }

        public void setInvoiceItemId(int invoiceItemId) {
            this.invoiceItemId = invoiceItemId;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getTaxAmount() {
            return taxAmount;
        }

        public void setTaxAmount(int taxAmount) {
            this.taxAmount = taxAmount;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
