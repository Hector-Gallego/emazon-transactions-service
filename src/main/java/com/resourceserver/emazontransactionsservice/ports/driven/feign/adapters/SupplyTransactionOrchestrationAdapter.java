package com.resourceserver.emazontransactionsservice.ports.driven.feign.adapters;

import com.resourceserver.emazontransactionsservice.domain.exception.StockUpdateException;
import com.resourceserver.emazontransactionsservice.domain.exception.SupplyOrchestrationException;
import com.resourceserver.emazontransactionsservice.domain.exception.TransactionCreationException;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionFeignPort;
import com.resourceserver.emazontransactionsservice.domain.feign.SupplyTransactionOrchestrationFeignPort;
import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;
import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;
import com.resourceserver.emazontransactionsservice.domain.security.AuthenticatedManagerPort;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.interfaces.StockMicroServiceFeignClient;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.mapper.StockRequestDtoMapper;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.StockRequestDto;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.response.CustomApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SupplyTransactionOrchestrationAdapter implements SupplyTransactionOrchestrationFeignPort {


    private final StockMicroServiceFeignClient stockMicroServiceFeignClient;
    private final StockRequestDtoMapper stockRequestDtoMapper;
    private final SupplyTransactionFeignPort supplyTransactionFeignPort;
    private final AuthenticatedManagerPort authenticatedManagerPort;


    public SupplyTransactionOrchestrationAdapter(
            StockMicroServiceFeignClient stockMicroServiceFeignClient,
            StockRequestDtoMapper stockRequestDtoMapper,
            SupplyTransactionFeignPort supplyTransactionFeignPort, AuthenticatedManagerPort authenticatedManagerPort) {

        this.stockMicroServiceFeignClient = stockMicroServiceFeignClient;
        this.stockRequestDtoMapper = stockRequestDtoMapper;
        this.supplyTransactionFeignPort = supplyTransactionFeignPort;
        this.authenticatedManagerPort = authenticatedManagerPort;
    }

    @Override
    public void orchestrateSupplyTransaction(SupplyTransactionDetails supplyTransactionDetails) {

        boolean stockUpdated = false;
        StockRequestDto stockRequestDto =
                stockRequestDtoMapper.toDto(supplyTransactionDetails);

        try {

            ResponseEntity<CustomApiResponse> stockResponse = stockMicroServiceFeignClient.addSupply(stockRequestDto);
            if (!stockResponse.getStatusCode().is2xxSuccessful()) {
                throw new StockUpdateException("error al actualizar stock");
            }

            stockUpdated = true;

            try {
                SupplyReport supplyReport = new SupplyReport();

                supplyReport.setArticleId(supplyTransactionDetails.getArticleId());
                supplyReport.setArticleName(supplyTransactionDetails.getArticleName());
                supplyReport.setQuantity(supplyTransactionDetails.getQuantity());
                supplyReport.setTransactionDate(LocalDateTime.now());
                supplyReport.setUserId(authenticatedManagerPort.getUserId());

                supplyTransactionFeignPort.saveSupplyTransaction(supplyReport);

            } catch (Exception e) {
                throw new TransactionCreationException();
            }

        } catch (TransactionCreationException e) {
            if (stockUpdated) {
                compensateSupplyTransaction(stockRequestDto);
            }
            throw new SupplyOrchestrationException();

        } catch (StockUpdateException e) {
            throw new SupplyOrchestrationException();

        }
    }

    private void compensateSupplyTransaction(StockRequestDto stockRequestDto) {
        StockRequestDto compensationStockRequest = new StockRequestDto(stockRequestDto.getArticleId(), -stockRequestDto.getQuantity());
        stockMicroServiceFeignClient.addSupply(compensationStockRequest);
    }

}
