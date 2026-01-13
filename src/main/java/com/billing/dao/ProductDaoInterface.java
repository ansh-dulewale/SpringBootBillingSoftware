package com.billing.dao;

import com.billing.entity.Product;

import java.util.List;

public interface ProductDaoInterface {
    List<Product> getAll();
    Product saveInterface(Product product);
    Product getByIdInteraface(int id);
    void deleteByIdInterface(int id);
    Product updateInterface(int id, Product product);
}
