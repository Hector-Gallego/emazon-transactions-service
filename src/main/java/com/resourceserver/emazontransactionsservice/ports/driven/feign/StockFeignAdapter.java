package com.resourceserver.emazontransactionsservice.ports.driven.feign;

import com.resourceserver.emazontransactionsservice.domain.feign.StockFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.ports.driving.mapper.SupplyToSupplyDtoMapper;

public class StockFeignAdapter implements StockFeignPort {

    private final StockFeignClient stockFeignClient;
    private final SupplyToSupplyDtoMapper supplyDtoMapper;

    public StockFeignAdapter(StockFeignClient stockFeignClient, SupplyToSupplyDtoMapper supplyDtoMapper) {
        this.stockFeignClient = stockFeignClient;
        this.supplyDtoMapper = supplyDtoMapper;
    }

    @Override
    public void addSupply(Supply supply) {
        stockFeignClient.addStock(supplyDtoMapper.toDto(supply));
    }

}
