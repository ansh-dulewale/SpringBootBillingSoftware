package com.billing.dao;

import com.billing.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDao implements ProductDaoInterface{
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    Product product = new Product();

    public ProductDao(){}
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query(
                "Select * from Product",
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
                , new BeanPropertyRowMapper<>(Product.class)
        );

        return product;
    }

    @Override
    public Product getByIdInteraface(int id) {
        String sql = "Select * from Product where id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Product.class), id
        );
    }

    @Override
    public Product deleteByIdInterface(int id) {
        String sql = "DELETE FROM PRODUCT WHERE id = ?";
        return jdbcTemplate.queryForObject(
                sql,
                new BeanPropertyRowMapper<>(Product.class), id
        );
    }

    @Override
    public Product updateInterface(int id, Product product) {

        String sql = "UPDATE product SET name = ?, price = ?, gst = ?, stock = ? WHERE id = ?";

        int rows = jdbcTemplate.update(
                sql,
                product.getName(),
                product.getPrice(),
                product.getGstPercentage(),
                product.getStockQuantity(),
                id
        );
        return product;
    }

}
