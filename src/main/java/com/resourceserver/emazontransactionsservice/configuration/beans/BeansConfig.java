package com.resourceserver.emazontransactionsservice.configuration.beans;

import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.domain.feign.StockFeignPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.usecase.AddSupplyUseCase;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter.SupplyJpaAdapter;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SupplyToSupplyEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SupplyRepository;
import com.resourceserver.emazontransactionsservice.ports.driving.mapper.SupplyToSupplyDtoMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.StockFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.StockFeignAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public SupplyServicePort supplyServicePort(StockFeignPort stockFeignPort, SupplyPersistencePort supplyPersistencePort){
        return new AddSupplyUseCase(stockFeignPort, supplyPersistencePort);
    }

    @Bean
    StockFeignPort supplyFeignPort(StockFeignClient stockFeignClient, SupplyToSupplyDtoMapper supplyDtoMapper){
        return new StockFeignAdapter(stockFeignClient, supplyDtoMapper);
    }

    @Bean
    public SupplyPersistencePort supplyTransactionPort(SupplyRepository supplyRepository, SupplyToSupplyEntityMapper supplyEntityMapper){
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

}
