package com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter;

import com.resourceserver.emazontransactionsservice.domain.model.Sale;
import com.resourceserver.emazontransactionsservice.domain.spi.SalePersistencePort;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SaleEntity;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SaleToSaleEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SaleRepository;

public class SaleJpaAdapter implements SalePersistencePort {

    private final SaleRepository saleRepository;
    private final SaleToSaleEntityMapper saleEntityMapper;

    public SaleJpaAdapter(SaleRepository saleRepository, SaleToSaleEntityMapper saleEntityMapper) {
        this.saleRepository = saleRepository;
        this.saleEntityMapper = saleEntityMapper;
    }

    @Override
    public Sale saveSale(Sale sale) {
        SaleEntity saleEntity = saleRepository.save(saleEntityMapper.toEntity(sale));
        return saleEntityMapper.toDomain(saleEntity);
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }
}
