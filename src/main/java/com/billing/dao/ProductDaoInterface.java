package com.billing.dao;

import com.billing.entity.Product;

import java.util.List;

public interface ProductDaoInterface {
    List<Product> getAll();
    Product saveInterface(Product product);
    Product getByIdInteraface(int id);
    Product deleteByIdInterface(int id);
    Product updateInterface(int id, Product product);
}
