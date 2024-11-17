package com.resourceserver.emazontransactionsservice.ports.driven.feign.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyTransactionDetails;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.StockRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StockRequestDtoMapper {

    SupplyTransactionDetails toDomain(StockRequestDto stockRequestDto);
    StockRequestDto toDto(SupplyTransactionDetails supplyTransactionDetails);
}
