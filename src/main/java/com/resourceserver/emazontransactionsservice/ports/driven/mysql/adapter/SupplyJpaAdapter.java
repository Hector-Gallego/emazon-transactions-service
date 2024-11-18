package com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SupplyToSupplyEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SupplyRepository;

public class SupplyJpaAdapter implements SupplyPersistencePort {

    private final SupplyRepository supplyRepository;
    private final SupplyToSupplyEntityMapper supplyEntityMapper;

    public SupplyJpaAdapter(SupplyRepository supplyRepository, SupplyToSupplyEntityMapper supplyEntityMapper) {
        this.supplyRepository = supplyRepository;
        this.supplyEntityMapper = supplyEntityMapper;
    }

    @Override
    public void saveSupplyTransaction(SupplyReport supplyReport) {
        supplyRepository.save(supplyEntityMapper.toEntity(supplyReport));
    }
}
