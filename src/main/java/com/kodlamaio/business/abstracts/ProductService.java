package com.kodlamaio.business.abstracts;

import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    Result add(Product product);

    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();
    DataResult<Product> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);
    DataResult<List<Product>>  getByNameAndCategory(String productName, int categoryId);
}
