package com.billing.dao;

import com.billing.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao implements ProductDaoInterface {

    private final JdbcTemplate jdbcTemplate;

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(
                "SELECT * FROM product",
                new BeanPropertyRowMapper<>(Product.class)
        );
    }

    @Override
    public Product saveInterface(Product product) {
        String sql = "INSERT INTO product (id, name, price, gst, stock) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                product.getProductId(),
                product.getName(),
                product.getPrice(),
                product.getGstPercentage(),
                product.getStockQuantity()
        );
        return product;
    }

    @Override
    public Product getByIdInteraface(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM product WHERE id = ?",
                new BeanPropertyRowMapper<>(Product.class),
                id
        );
    }

    @Override
    public void deleteByIdInterface(int id) {
        jdbcTemplate.update("DELETE FROM product WHERE id = ?", id);
    }

    @Override
    public Product updateInterface(int id, Product product) {
        String sql = "UPDATE product SET name=?, price=?, gst=?, stock=? WHERE id=?";

        jdbcTemplate.update(
                sql,
                product.getName(),
                product.getPrice(),
                product.getGstPercentage(),
                product.getStockQuantity(),
                id
        );
        return getByIdInteraface(id);
    }
}

