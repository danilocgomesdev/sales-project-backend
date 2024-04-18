package com.project.sales.services;

import com.project.sales.interfaces.ISaleItem;
import com.project.sales.model.Sale;
import com.project.sales.model.SaleItem;
import com.project.sales.repository.SaleItemRepository;
import com.project.sales.repository.SaleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SaleItemService implements ISaleItem<SaleItem, Integer> {
    @Autowired
    private SaleItemRepository saleItemRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleItem create(SaleItem entity) {
        return saleItemRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public SaleItem read(Integer id) {
        Optional<SaleItem> saleItem = saleItemRepository.findById(id);
        return saleItem.orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleItem> readAll() {
        return saleItemRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleItem updatePart(Integer id, SaleItem entity) {
        SaleItem saleItem = this.read(id);

        if (saleItem != null) {
            saleItem.setQuantity(entity.getQuantity());
            saleItem.setUnitPrice(entity.getUnitPrice());
            saleItem.setSale(entity.getSale());
            saleItem.setProduct(entity.getProduct());
            return saleItemRepository.save(saleItem);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SaleItem updateAll(Integer id, SaleItem entity) {
        SaleItem saleItem = this.read(id);

        if (saleItem != null) {
            saleItem.setQuantity(entity.getQuantity());
            saleItem.setUnitPrice(entity.getUnitPrice());
            saleItem.setSale(entity.getSale());
            saleItem.setProduct(entity.getProduct());
            return saleItemRepository.save(saleItem);
        }

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        saleItemRepository.deleteById(id);
    }
}