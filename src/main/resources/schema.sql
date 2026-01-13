CREATE TABLE IF NOT EXISTS customer (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    phone BIGINT,
    email VARCHAR(100),
    address VARCHAR(255)
);
CREATE TABLE IF NOT EXISTS Product (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    price INT,
    gst int,
    stock int
);
CREATE TABLE IF NOT EXISTS INVOICE(
    invoice_id int PRIMARY KEY,
    INVOICE_DATE INT,
    CUSTOMER_ID int,
    TOTAL_AMOUNT INT,
    TOTAL_TAX INT,
    DISCOUNT INT,
    FINAL_AMOUNT INT,
    CONSTRAINT fk_invoice foreign key (customer_id) references customer(customer_id)
);
CREATE TABLE IF NOT EXISTS invoice_item (
    id INT AUTO_INCREMENT PRIMARY KEY,
    invoice_id INT,
    product_id INT,
    quantity INT,
    price INT,
    tax_amount INT,
    total INT,
    FOREIGN KEY (invoice_id) REFERENCES invoice(invoice_id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);

