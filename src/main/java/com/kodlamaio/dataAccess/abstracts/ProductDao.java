package com.kodlamaio.dataAccess.abstracts;

import com.kodlamaio.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer> {
    Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    @Query("FROM Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);
}
