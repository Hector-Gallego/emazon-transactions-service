package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.domain.api.SupplyTransactionOrchestrationApiPort;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;

public class OrchestrateSupplyTransactionUseCase implements SupplyTransactionOrchestrationApiPort {

    private final SupplyTransactionOrchestrationFeignPort supplyTransactionOrchestrationFeignPort;

    public OrchestrateSupplyTransactionUseCase(SupplyTransactionOrchestrationFeignPort supplyTransactionOrchestrationFeignPort) {
        this.supplyTransactionOrchestrationFeignPort = supplyTransactionOrchestrationFeignPort;
    }

    @Override
    public void orchestrateSupplyTransaction(SupplyTransactionDetails supplyTransactionDetails) {
        supplyTransactionOrchestrationFeignPort.orchestrateSupplyTransaction(supplyTransactionDetails);
    }
}