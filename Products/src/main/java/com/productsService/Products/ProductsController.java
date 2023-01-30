package com.productsService.Products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("products")
public class ProductsController {
    @GetMapping
    public Products products(){
      Products products =new Products();
      products.name="Tea";
      products.id=1;
      products.price=500;
        return products;
    }
}
