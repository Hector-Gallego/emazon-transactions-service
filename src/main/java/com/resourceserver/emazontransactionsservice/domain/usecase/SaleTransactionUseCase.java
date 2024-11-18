package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.domain.api.SaleServicePort;
import com.resourceserver.emazontransactionsservice.domain.model.SaleReport;
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
    public Long saveSaleTransactionReport(SaleReport saleReport) {

        Long userId = authenticatedManagerPort.getUserId();
        saleReport.setSaleDate(LocalDateTime.now());
        saleReport.setUserId(userId);
        SaleReport persistSaleReport = salePersistencePort.saveSale(saleReport);
        return persistSaleReport.getId();

    }

    @Override
    public void deleteSale(Long id) {
        salePersistencePort.deleteSale(id);
    }
}
