package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.domain.feign.StockFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.validations.SupplyValidator;

import java.time.LocalDateTime;

public class AddSupplyUseCase implements SupplyServicePort {

    private final StockFeignPort stockFeignPort;
    private final SupplyPersistencePort supplyPersistencePort;

    public AddSupplyUseCase(StockFeignPort stockFeignPort, SupplyPersistencePort supplyPersistencePort) {
        this.stockFeignPort = stockFeignPort;
        this.supplyPersistencePort = supplyPersistencePort;
    }

    @Override
    public void addSupplyAndSaveTransaction(Supply supply) {

        SupplyValidator.validateSupply(supply);
        supply.setTransactionDate(LocalDateTime.now());
        stockFeignPort.addSupply(supply);
        supplyPersistencePort.saveSupplyTransactions(supply);
    }
}
