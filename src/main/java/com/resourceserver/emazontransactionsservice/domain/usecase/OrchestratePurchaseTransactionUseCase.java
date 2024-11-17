package com.resourceserver.emazontransactionsservice.domain.usecase;

import com.resourceserver.emazontransactionsservice.domain.api.PurchaseTransactionOrchestrationApiPort;
import com.resourceserver.emazontransactionsservice.domain.feign.PurchaseTransactionOrchestrationFeignPort;

public class OrchestratePurchaseTransactionUseCase implements PurchaseTransactionOrchestrationApiPort {

    private final PurchaseTransactionOrchestrationFeignPort purchaseTransactionOrchestrationFeignPort;

    public OrchestratePurchaseTransactionUseCase(PurchaseTransactionOrchestrationFeignPort purchaseTransactionOrchestrationFeignPort) {
        this.purchaseTransactionOrchestrationFeignPort = purchaseTransactionOrchestrationFeignPort;
    }

    @Override
    public void orchestratePurchaseTransaction() {
        purchaseTransactionOrchestrationFeignPort.orchestratePurchaseTransaction();
    }
}
