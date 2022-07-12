package com.demo.hplus.controllers;

import com.demo.hplus.models.Product;
import com.demo.hplus.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("in search controller");
        System.out.println("search criteria: " + search);

        List<Product> products;
        products = productRepository.searchByName(search);
        model.addAttribute("products", products);

        return "search";
    }
}
