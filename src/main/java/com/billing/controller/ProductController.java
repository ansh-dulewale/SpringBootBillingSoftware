package com.billing.controller;
import com.billing.dao.ProductDao;
import com.billing.entity.Product;
import com.billing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService service;
    ProductDao productDao;

    public ProductController(ProductService productService){

        this.service = productService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll(){
        try {
            return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody Product product){

        return new ResponseEntity<>(service.createProduct(product),HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id){
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deleteById(@PathVariable int id){
        try {
            return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateById(@PathVariable int id, @RequestBody Product p){
        try {
            return ResponseEntity.ok(service.updateProduct(id,p));
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{search}")
    public List<Product> search(){
        return service.getAllProducts();
    }
}
