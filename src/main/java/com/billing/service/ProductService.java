package com.billing.service;

import com.billing.dao.ProductDao;
import com.billing.entity.Product;
import com.billing.exception.ResourceNotFoundException;
import com.billing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository repository;
    ProductDao productDao = new ProductDao();

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product createProduct(Product product){
        return productDao.saveInterface(product);
    }

    public Product findById(int id){
        return productDao.getByIdInteraface(id);
    }

    public Product deleteById(int id){
        return productDao.deleteByIdInterface(id);
    }

    public Product updateProduct(int id, Product product){
        return productDao.updateInterface(id, product);
    }

}
