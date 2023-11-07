package com.kodlamaio.business.concretes;

import com.kodlamaio.business.abstracts.ProductService;
import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.dataAccess.abstracts.ProductDao;
import com.kodlamaio.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    ProductDao _productDao;

    @Autowired
    public ProductManager(ProductDao _productDao) {
        this._productDao = _productDao;
    }

    @Override
    public Result add(Product product) {
        this._productDao.save(product);
        return new SuccessResult("Ürün Eklendi");
    }

    @Override
    public Result Delete(int id) {
        return null;
    }

    @Override
    public Result Update(Product product) {
        return null;
    }

    @Override
    public DataResult<List<Product>> getAll() {
       return new SuccessDataResult<>("Success",this._productDao.findAll());
    }

    @Override
    public DataResult<Product> getById() {
        return null;
    }
}
