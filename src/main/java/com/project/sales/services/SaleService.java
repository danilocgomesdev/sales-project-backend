package com.project.sales.services;

import com.project.sales.interfaces.ISale;
import com.project.sales.model.Sale;
import com.project.sales.repository.SaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SaleService implements ISale<Sale, Integer> {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Sale create(Sale entity) {
        return saleRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public Sale read(Integer id) {
        Optional<Sale> sale = saleRepository.findById(id);
        return sale.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Sale> readAll() {
        return saleRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Sale updatePart(Integer id, Sale entity) {
        Sale sale = this.read(id);

        if (sale != null) {
            sale.setDateSale(entity.getDateSale());
            sale.setAmount(entity.getAmount());
            sale.setClient(entity.getClient());
            return saleRepository.save(sale);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Sale updateAll(Integer id, Sale entity) {
        Sale sale = this.read(id);

        if (sale != null) {
            sale.setDateSale(entity.getDateSale());
            sale.setAmount(entity.getAmount());
            sale.setClient(entity.getClient());
            return saleRepository.save(sale);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        saleRepository.deleteById(id);
    }
}