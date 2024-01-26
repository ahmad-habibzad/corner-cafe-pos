package dev.habibzad.brewscape.controller;


import dev.habibzad.brewscape.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    //Todo create product dao

    private final List<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();
        products.add(new Product("Coffee", 2.99));
        products.add(new Product("Latte", 3.99));
        products.add(new Product("Tea", 1.99));
    }

    @GetMapping("/products")
    public List<Product> listProducts(){
        return products;
    }

    @GetMapping("/products/{name}")
    public Product findProductByName(@PathVariable String name){
        return products.stream().filter(product -> product.getName().equals(name)).findFirst().orElseThrow();
    }
}
