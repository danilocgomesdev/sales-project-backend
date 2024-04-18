package com.project.sales.resources;

import com.project.sales.interfaces.ISale;
import com.project.sales.model.Sale;
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
@RequestMapping(value = "/api/v1/sale")
public class SaleResource implements ISale<Sale, Integer> {

    @Autowired
    private SaleService saleService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Sale create(@Valid @RequestBody Sale entity) {
        return saleService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Sale read(@PathVariable Integer id) {
        return saleService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Sale> readAll() {
        return saleService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Sale updatePart(@PathVariable Integer id, @Valid @RequestBody Sale entity) {
        return saleService.updatePart(id, entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Sale updateAll(@PathVariable Integer id, @Valid @RequestBody Sale entity) {
        return saleService.updateAll(id, entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        saleService.delete(id);
    }
}
