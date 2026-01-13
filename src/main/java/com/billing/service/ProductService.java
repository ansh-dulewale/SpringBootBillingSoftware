package com.billing.service;

import com.billing.dao.ProductDao;
import com.billing.entity.Product;
import com.billing.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getAllProducts() {
        return productDao.getAll();
    }

    public Product createProduct(Product product) {
        return productDao.saveInterface(product);
    }

    public Product findById(int id) {
        return productDao.getByIdInteraface(id);
    }

    public void deleteById(int id) {
        productDao.deleteByIdInterface(id);
    }

    public Product updateProduct(int id, Product product) {
        return productDao.updateInterface(id, product);
    }
}

