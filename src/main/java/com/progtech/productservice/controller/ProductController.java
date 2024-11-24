package com.progtech.productservice.controller;

import java.util.List;
import java.util.Optional;
import com.progtech.productservice.model.Product;
import com.progtech.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired private ProductService productService;

    // Save operation
    @PostMapping("/products")
    public Product saveProduct(@Validated @RequestBody Product product)
    {
        return productService.saveProduct(product);
    }

    // Read operation
    @GetMapping("/products")
    public List<Product> fetchDepartmentList()
    {
        return productService.fetchAllProducts();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getDepartmentById(@PathVariable("id") Long departmentId)
    {
        return productService.getProductById(departmentId);
    }

    // Update operation
    @PutMapping("/products/{id}")
    public Product updateDepartment(@RequestBody Product product, @PathVariable("id") Long productId)
    {
        return productService.updateProduct(product, productId);
    }

    // Delete operation
    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable("id") Long productId)
    {
        productService.deleteProductById(productId);
        return "Deleted Successfully";
    }
}