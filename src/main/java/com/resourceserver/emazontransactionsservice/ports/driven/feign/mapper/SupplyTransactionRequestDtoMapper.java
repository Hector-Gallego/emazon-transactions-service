package com.resourceserver.emazontransactionsservice.ports.driven.feign.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.dtos.SupplyTransactionRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyTransactionRequestDtoMapper {
    SupplyTransactionDetails toDomain(SupplyTransactionRequestDto supplyTransactionRequestDto);
    SupplyTransactionRequestDto toDto(SupplyTransactionDetails supplyTransactionDetails);
}
