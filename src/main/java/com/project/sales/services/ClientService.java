package com.project.sales.services;

import com.project.sales.interfaces.IClient;
import com.project.sales.model.Client;
import com.project.sales.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService implements IClient<Client, Integer> {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Client create(Client entity) {
        return clientRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Client read(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> readAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Client updatePart(Integer id, Client entity) {
        Client client = this.read(id);

        if (client != null) {
            // Update only the necessary fields
            client.setName(entity.getName());
            client.setAdressEmail(entity.getAdressEmail());
            client.setDateOfBirth(entity.getDateOfBirth());
            return clientRepository.save(client);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Client updateAll(Integer id, Client entity) {
        Client client = this.read(id);

        if (client != null) {
            client.setName(entity.getName());
            client.setAdressEmail(entity.getAdressEmail());
            client.setDateOfBirth(entity.getDateOfBirth());
            return clientRepository.save(client);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}