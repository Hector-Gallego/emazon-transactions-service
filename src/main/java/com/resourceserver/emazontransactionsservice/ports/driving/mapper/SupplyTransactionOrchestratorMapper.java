package com.resourceserver.emazontransactionsservice.ports.driving.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SupplyTransactionOrchestratorRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyTransactionOrchestratorMapper {

    SupplyTransactionDetails toDomain(SupplyTransactionOrchestratorRequestDto SupplyTransactionOrchestratorRequestDto);
    SupplyTransactionOrchestratorRequestDto toDto(SupplyTransactionDetails supplyTransactionDetails);
}