package com.project.sales.resources;

import com.project.sales.interfaces.ISale;
import com.project.sales.interfaces.ISaleItem;
import com.project.sales.model.Sale;
import com.project.sales.model.SaleItem;
import com.project.sales.services.SaleItemService;
import com.project.sales.services.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/sale-item")
public class SaleItemResource implements ISaleItem<SaleItem, Integer> {
    @Autowired
    private SaleItemService saleItemService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public SaleItem create(@Valid @RequestBody SaleItem entity) {
        return saleItemService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public SaleItem read(@PathVariable Integer id) {
        return saleItemService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<SaleItem> readAll() {
        return saleItemService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public SaleItem updatePart(@PathVariable Integer id, @Valid @RequestBody SaleItem entity) {
        return saleItemService.updatePart(id, entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public SaleItem updateAll(@PathVariable Integer id, @Valid @RequestBody SaleItem entity) {
        return saleItemService.updateAll(id, entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        saleItemService.delete(id);
    }
}

