package com.billing.repository;

import com.billing.exception.ResourceNotFoundException;
import com.billing.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final ArrayList<Product> list = new ArrayList<>();

    public List<Product> findAll(){
        return list;
    }

    public Product findById(int id){
        return list.stream().filter(p -> p.getProductId() == id).findFirst().orElse(null);
    }

    public void save(Product product){
        list.add(product);
    }

    public Product deleteById(int id){
        Product p = new Product();
        //Method 1
        for(int i = 0; i < list.size(); i++){
            if (list.get(i).getProductId() == id ){
                p = list.get(i);
                list.remove(i);
            }
        }
        return p;
    }

    public Product updateById(int id, Product product){
        Product existingProduct = findById(id);
        if (existingProduct != null){
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStockQuantity(product.getStockQuantity());
            return product;
        }else{
            throw new ResourceNotFoundException("Product Not Found");
        }
    }
}