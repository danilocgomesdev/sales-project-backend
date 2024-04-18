package com.project.sales.resources;

import com.project.sales.interfaces.IProduct;
import com.project.sales.model.Product;
import com.project.sales.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/product")
public class ProductResource implements IProduct<Product, Integer> {
    @Autowired
    private ProductService productService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Product create(@Valid @RequestBody Product entity) {
        return productService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Product read(@PathVariable Integer id) {
        return productService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Product> readAll() {
        return productService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Product updatePart(@PathVariable Integer id, @Valid @RequestBody Product entity) {
        return productService.updatePart(id, entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Product updateAll(@PathVariable Integer id, @Valid @RequestBody Product entity) {
        return productService.updateAll(id, entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
}