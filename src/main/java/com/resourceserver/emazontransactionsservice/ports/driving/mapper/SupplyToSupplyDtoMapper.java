package com.resourceserver.emazontransactionsservice.ports.driving.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.SupplyReport;
import com.resourceserver.emazontransactionsservice.ports.driven.feign.dtos.SupplyRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyToSupplyDtoMapper {
    SupplyReport toDomain(SupplyRequestDto supplyRequestDto);
}
