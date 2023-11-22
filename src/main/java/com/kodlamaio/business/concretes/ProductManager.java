package com.kodlamaio.business.concretes;

import com.kodlamaio.business.abstracts.ProductService;
import com.kodlamaio.core.utilities.results.DataResult;
import com.kodlamaio.core.utilities.results.Result;
import com.kodlamaio.core.utilities.results.SuccessDataResult;
import com.kodlamaio.core.utilities.results.SuccessResult;
import com.kodlamaio.dataAccess.abstracts.ProductDao;
import com.kodlamaio.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAll() {
       return new SuccessDataResult<>("Success",this._productDao.findAll());
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable= PageRequest.of(pageNo-1, pageSize);
        return new SuccessDataResult<>(this._productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort= Sort.by(Sort.Direction.DESC, "productName");
        return new SuccessDataResult<>(this._productDao.findAll(sort));
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<>("Success",this._productDao.getByProductName(productName));

    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>("Success",this._productDao.getByProductNameAndCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
        return new SuccessDataResult<>("Success",this._productDao.getByProductNameOrCategory_CategoryId(productName,categoryId));
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<>("Success",this._productDao.getByCategoryIn(categories));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>("Success",this._productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<>("Success",this._productDao.getByProductNameStartsWith(productName));
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<>("Success",this._productDao.getByNameAndCategory(productName,categoryId));
    }
}
