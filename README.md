# Billing Software

A Spring Boot REST API for managing invoices, customers, and products.

## Tech Stack

- Java 25
- Spring Boot 4.0.1
- Maven
- SpringDoc OpenAPI (Swagger UI)

## API Endpoints

### Invoice
- `POST /invoice` - Create invoice
- `GET /invoice` - Get all invoices
- `GET /invoice/{id}` - Get invoice by ID
- `GET /invoice/customer/{id}` - Get invoices by customer

### Customer & Product
- CRUD operations via `/customer` and `/product` endpoints

## Run

```bash
mvn spring-boot:run
```

## API Docs

Swagger UI: `http://localhost:8080/swagger-ui.html`

