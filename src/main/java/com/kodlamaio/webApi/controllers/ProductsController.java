package com.kodlamaio.webApi.controllers;

import com.kodlamaio.business.abstracts.ProductService;
import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.core.utilities.results.SuccessDataResult;
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


    @GetMapping("/getbyproductname")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this._productService.getByProductName(productName);

    }

    @GetMapping("/getbyproductnameandcategoryid")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this._productService.getByProductNameAndCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getbyproductnameorcategoryid")
    public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName, @RequestParam int categoryId) {
        return this._productService.getByProductNameOrCategory_CategoryId(productName,categoryId);
    }

    @GetMapping("/getbycategoryidin")
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return this._productService.getByCategoryIn(categories);
    }

    @GetMapping("/getbyproductnamecontains")
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return this._productService.getByProductNameContains(productName);
    }

    @GetMapping("/getbyproductnamestartswith")
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return this._productService.getByProductNameStartsWith(productName);
    }

    @GetMapping("/getbynameandcategory")
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return this._productService.getByNameAndCategory(productName,categoryId);
    }

    @GetMapping("/getAllByPage")
    DataResult<List<Product>> getAll(int pageNo, int pageSize){
        return this._productService.getAll(pageNo,pageSize);
    }

    @GetMapping("/getallsorted")
    public DataResult<List<Product>> getAllSorted(){
        return this._productService.getAllSorted();
    }
}
