package com.billing.service;

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

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product createProduct(Product product){
        try {
            repository.save(product);
        }catch (Exception e){
            System.out.println(e);
            throw e;
        }
        return product;
    }

    public Product findById(int id){
        try {
            return repository.findById(id);
        }catch (Exception e){
            throw e;
        }
    }

    public Product deleteById(int id){
        try {
            return repository.deleteById(id);

        }catch (Exception e){
            throw e;
        }
    }

    public Product updateProduct(int id, Product product){
        try {
            return repository.updateById(id, product);
        }catch (ResourceNotFoundException e){
            throw e;
        }
    }

}
