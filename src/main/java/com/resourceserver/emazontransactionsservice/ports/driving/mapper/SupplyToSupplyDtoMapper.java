package com.resourceserver.emazontransactionsservice.ports.driving.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SupplyRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyToSupplyDtoMapper {
    Supply toDomain(SupplyRequestDto supplyRequestDto);
}
