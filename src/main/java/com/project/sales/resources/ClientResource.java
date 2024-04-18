package com.project.sales.resources;

import com.project.sales.interfaces.IClient;
import com.project.sales.model.Client;
import com.project.sales.services.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping(value = "/api/v1/client")
public class ClientResource implements IClient<Client, Integer> {
    @Autowired
    private ClientService clientService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Client create(@Valid @RequestBody Client entity) {
        return clientService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Client read(@PathVariable Integer id) {
        return clientService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Client> readAll() {
        return clientService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Client updatePart(@PathVariable Integer id,@Valid @RequestBody Client entity) {
        return clientService.updatePart(id, entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Client updateAll(@PathVariable Integer id, @Valid @RequestBody Client entity) {
        return updateAll(id, entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        clientService.delete(id);
    }
}
