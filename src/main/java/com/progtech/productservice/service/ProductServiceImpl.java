package com.progtech.productservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.progtech.productservice.model.Product;
import com.progtech.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save operation
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Read operation
    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
//        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // Update operation
    @Override
    public Product
    updateProduct(Product product, Long productId) {

        Product productDb = productRepository.findById(productId).get();

        if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
            productDb.setProductName(product.getProductName());
        }

        if (Objects.nonNull(product.getProductAddress()) && !"".equalsIgnoreCase(product.getProductAddress())) {
            productDb.setProductAddress(product.getProductAddress());
        }

        if (Objects.nonNull(product.getProductCode()) && !"".equalsIgnoreCase(product.getProductCode())) {
            productDb.setProductCode(product.getProductCode());
        }

        return productRepository.save(productDb);
    }

    // Delete operation
    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}