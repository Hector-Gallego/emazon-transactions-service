package com.resourceserver.emazontransactionsservice.configuration.beans;

import com.resourceserver.emazontransactionsservice.configuration.security.services.AuthenticatedUserManager;
import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.usecase.SupplyTransactionUseCase;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter.SupplyJpaAdapter;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SupplyToSupplyEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SupplyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public SupplyServicePort supplyServicePort( SupplyPersistencePort supplyPersistencePort, AuthenticatedManagerPort authenticatedManagerPort){
        return new SupplyTransactionUseCase(supplyPersistencePort, authenticatedManagerPort);
    }

    @Bean
    public SupplyPersistencePort supplyTransactionPort(SupplyRepository supplyRepository, SupplyToSupplyEntityMapper supplyEntityMapper){
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    AuthenticatedManagerPort authenticatedManagerPort(){
        return new AuthenticatedUserManager();
    }

}
