package com.progtech.productservice.service;
import com.progtech.productservice.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    // Save operation
    Product saveProduct(Product department);

    // Get all products
    List<Product> fetchAllProducts();

    // Get Department By Id
    Optional<Product> getProductById(Long id);

    // Update operation
    Product updateProduct(Product product, Long productId);

    // Delete operation
    void deleteProductById(Long productId);
}