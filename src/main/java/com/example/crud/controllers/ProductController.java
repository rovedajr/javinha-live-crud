package com.example.crud.controllers;

import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import com.example.crud.domain.product.RequestProduct;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){

        var allProducts = repository.findAllByActiveTrue();

        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<?> registerProduct(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody @Valid RequestProduct data){

        Optional<Product> optionalProduct = repository.findById(data.id());

        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            product.setName(data.name());

            product.setPriceInCents(data.priceInCents());

            Product updatedProduct = repository.save(product);
            return ResponseEntity.ok(updatedProduct);

        } else {
            throw new EntityNotFoundException();
        }

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        Optional<Product> optionalProduct = repository.findById(id);
        if(optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setActive(false);
            return ResponseEntity.noContent().build();
        } else {
            return  ResponseEntity.notFound().build();
        }

    }
}