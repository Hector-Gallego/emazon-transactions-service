package com.resourceserver.emazontransactionsservice.configuration.beans;

import com.resourceserver.emazontransactionsservice.configuration.security.services.AuthenticatedUserManager;
import com.resourceserver.emazontransactionsservice.domain.api.PurchaseTransactionOrchestrationApiPort;
import com.resourceserver.emazontransactionsservice.domain.api.SaleServicePort;
import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.domain.api.SupplyTransactionOrchestrationApiPort;
import com.resourceserver.emazontransactionsservice.domain.feign.PurchaseTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionFeignPort;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SalePersistencePort;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.usecase.OrchestratePurchaseTransactionUseCase;
import com.resourceserver.emazontransactionsservice.domain.usecase.OrchestrateSupplyTransactionUseCase;
import com.resourceserver.emazontransactionsservice.domain.usecase.SaleTransactionUseCase;
import com.resourceserver.emazontransactionsservice.domain.usecase.SupplyTransactionUseCase;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.adapters.PurchaseTransactionOrchestratorAdapter;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ReportServiceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.ShoppingCartMicroserviceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.StockMicroServiceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter.SaleJpaAdapter;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.adapter.SupplyJpaAdapter;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SaleToSaleEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper.SupplyToSupplyEntityMapper;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SaleRepository;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository.SupplyRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {


    @Bean
    public SaleServicePort saleServicePort(SalePersistencePort salePersistencePort, AuthenticatedManagerPort authenticatedManagerPort) {
        return new SaleTransactionUseCase(salePersistencePort, authenticatedManagerPort);
    }

    @Bean
    public SalePersistencePort salePersistencePort(SaleRepository saleRepository, SaleToSaleEntityMapper saleToSaleEntityMapper) {
        return new SaleJpaAdapter(saleRepository, saleToSaleEntityMapper);
    }

    @Bean
    public SupplyTransactionFeignPort supplyServicePort(SupplyPersistencePort supplyPersistencePort, AuthenticatedManagerPort authenticatedManagerPort) {
        return new SupplyTransactionUseCase(supplyPersistencePort, authenticatedManagerPort);
    }

    @Bean
    public SupplyPersistencePort supplyTransactionPort(SupplyRepository supplyRepository, SupplyToSupplyEntityMapper supplyEntityMapper) {
        return new SupplyJpaAdapter(supplyRepository, supplyEntityMapper);
    }

    @Bean
    AuthenticatedManagerPort authenticatedManagerPort() {
        return new AuthenticatedUserManager();
    }

    @Bean
    SupplyTransactionOrchestrationApiPort supplyTransactionOrchestrationApiPort(SupplyTransactionOrchestrationFeignPort supplyTransactionOrchestrationFeignPort) {
        return new OrchestrateSupplyTransactionUseCase(supplyTransactionOrchestrationFeignPort);

    }

    @Bean
    PurchaseTransactionOrchestrationFeignPort purchaseTransactionOrchestrationFeignPort(
            ShoppingCartMicroserviceFeignClient shoppingCartMicroserviceFeignClient,
            StockMicroServiceFeignClient stockMicroServiceFeignClient,
            ReportServiceFeignClient reportServiceFeignClient) {
        return new PurchaseTransactionOrchestratorAdapter(shoppingCartMicroserviceFeignClient, stockMicroServiceFeignClient, reportServiceFeignClient);
    }

    @Bean
    PurchaseTransactionOrchestrationApiPort purchaseTransactionOrchestrationApiPort(PurchaseTransactionOrchestrationFeignPort purchaseTransactionOrchestrationFeignPort) {
        return new OrchestratePurchaseTransactionUseCase(purchaseTransactionOrchestrationFeignPort);

    }
}
