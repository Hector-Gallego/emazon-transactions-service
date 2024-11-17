package com.resourceserver.emazontransactionsservice.ports.driving.controller;

import com.resourceserver.emazontransactionsservice.domain.api.PurchaseTransactionOrchestrationApiPort;
import com.resourceserver.emazontransactionsservice.domain.constants.SuccessMessagesConstants;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SupplyTransactionOrchestratorRequestDto;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.response.CustomApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController()
@RequestMapping("/api/transactions")
public class PurchaseTransactionOrchestratorController {

    private final PurchaseTransactionOrchestrationApiPort purchaseTransactionOrchestrationApiPort;

    public PurchaseTransactionOrchestratorController(PurchaseTransactionOrchestrationApiPort purchaseTransactionOrchestrationApiPort) {
        this.purchaseTransactionOrchestrationApiPort = purchaseTransactionOrchestrationApiPort;
    }

    @PostMapping("/purchase")
    public ResponseEntity<CustomApiResponse> orchestrateSupply() {

        purchaseTransactionOrchestrationApiPort.orchestratePurchaseTransaction();
        CustomApiResponse response = new CustomApiResponse(
                HttpStatus.OK.value(),
                SuccessMessagesConstants.ADD_STOCK_AND_SUPPLY_TRANSACTION_SUCCESS,
                LocalDateTime.now()
        );

        return ResponseEntity.ok(response);
    }
}
