package com.demo.hplus.restcontrollers;

import com.demo.hplus.models.Product;
import com.demo.hplus.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

   /* @ResponseBody
    @GetMapping("/hplus/api/v3/products")
    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();

        productRepository.findAll().forEach(product -> products.add(product));

        return products;
    }*/

    @GetMapping("/hplus/api/v3/products")
    public ResponseEntity getProductByParameter(@RequestParam("name") String name){
        List<Product> products = productRepository.searchByName(name);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/hplus/api/v3/products/{name}")
    public ResponseEntity getProductById(@PathVariable("name") String name){

        List<Product> products = productRepository.searchByName(name);

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

