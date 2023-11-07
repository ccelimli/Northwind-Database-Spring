package com.kodlamaio.business.abstracts;

import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.entities.concretes.Product;

import java.util.List;

public interface ProductService {
    Result Add(Product product);
    Result Delete(int id);
    Result Update(Product product);
   DataResult<List<Product>> getAll();
    DataResult<Product> getById();
}
