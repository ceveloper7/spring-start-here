package com.gba.sprg_ch08_ex4.controller;

import com.gba.sprg_ch08_ex4.model.Product;
import com.gba.sprg_ch08_ex4.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService){
        this.productService = productService;
    }


    @GetMapping("/products")
    public String viewProducts(Model model){
        var products = productService.findAll();
        model.addAttribute("products", products);

        return "products.html";
    }

    @PostMapping(path = "/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, Model page){
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);

        productService.addProduct(p);

        var products = productService.findAll();
        page.addAttribute("products", products);

        return "products.html";
    }

}
