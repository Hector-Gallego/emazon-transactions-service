package com.resourceserver.emazontransactionsservice.domain.usecase;
import com.resourceserver.emazontransactionsservice.domain.api.SupplyServicePort;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.domain.spi.SupplyPersistencePort;
import com.resourceserver.emazontransactionsservice.domain.validator.SupplyValidator;

import java.time.LocalDateTime;

public class SupplyTransactionUseCase implements SupplyTransactionFeignPort {


    private final SupplyPersistencePort supplyPersistencePort;
    private final AuthenticatedManagerPort authenticatedManagerPort;

    public SupplyTransactionUseCase(SupplyPersistencePort supplyPersistencePort, AuthenticatedManagerPort authenticatedManagerPort) {

        this.supplyPersistencePort = supplyPersistencePort;
        this.authenticatedManagerPort = authenticatedManagerPort;
    }

    @Override
    public void saveSupplyTransaction(Supply supply) {

        SupplyValidator.validateSupply(supply);
        supply.setUserId(authenticatedManagerPort.getUserId());
        supply.setTransactionDate(LocalDateTime.now());
        supplyPersistencePort.saveSupplyTransaction(supply);
    }
}
