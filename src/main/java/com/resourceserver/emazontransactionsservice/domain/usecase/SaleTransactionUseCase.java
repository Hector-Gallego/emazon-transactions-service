package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.domain.api.SaleServicePort;
import com.resourceserver.emazontransactionsservice.domain.model.Sale;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SalePersistencePort;

import java.time.LocalDateTime;

public class SaleTransactionUseCase implements SaleServicePort {

    private final SalePersistencePort salePersistencePort;
    private final AuthenticatedManagerPort authenticatedManagerPort;

    public SaleTransactionUseCase(SalePersistencePort salePersistencePort, AuthenticatedManagerPort authenticatedManagerPort) {
        this.salePersistencePort = salePersistencePort;
        this.authenticatedManagerPort = authenticatedManagerPort;
    }

    @Override
    public Long saveSale(Sale sale) {

        Long userId = authenticatedManagerPort.getUserId();
        sale.setSaleDate(LocalDateTime.now());
        sale.setUserId(userId);
        Sale persistSale = salePersistencePort.saveSale(sale);
        return persistSale.getId();

    }

    @Override
    public void deleteSale(Long id) {
        salePersistencePort.deleteSale(id);
    }
}
