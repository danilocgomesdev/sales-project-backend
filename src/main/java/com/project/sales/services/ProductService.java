package com.project.sales.services;

import com.project.sales.interfaces.IProduct;
import com.project.sales.model.Product;
import com.project.sales.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductService implements IProduct<Product, Integer> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product create(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Product read(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> readAll() {
        return productRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product updatePart(Integer id, Product entity) {
        Product product = this.read(id);

        if (product != null) {
            product.setNameProduct(entity.getNameProduct());
            product.setDescriptionProduct(entity.getDescriptionProduct());
            product.setPriceProduct(entity.getPriceProduct());
            return productRepository.save(product);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Product updateAll(Integer id, Product entity) {
        Product product = this.read(id);

        if (product != null) {
            // Update all fields
            product.setNameProduct(entity.getNameProduct());
            product.setDescriptionProduct(entity.getDescriptionProduct());
            product.setPriceProduct(entity.getPriceProduct());
            return productRepository.save(product);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        productRepository.deleteById(id);
    }
}
