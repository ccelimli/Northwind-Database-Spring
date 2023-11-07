package com.kodlamaio.webApi.controllers;

import com.kodlamaio.business.abstracts.ProductService;
import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
    private ProductService _productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this._productService = productService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this._productService.add(product);
    }

    @GetMapping("/getall")
    public DataResult<List<Product>> getAll(){
        return this._productService.getAll();
    }

}
