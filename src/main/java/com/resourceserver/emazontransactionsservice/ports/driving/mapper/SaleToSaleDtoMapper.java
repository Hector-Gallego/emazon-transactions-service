package com.resourceserver.emazontransactionsservice.ports.driving.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.Sale;
import com.resourceserver.emazontransactionsservice.ports.driving.dto.request.SaleRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SaleToSaleDtoMapper {


    Sale toDomain(SaleRequestDto saleRequestDto);
    SaleRequestDto toDto(Sale sale);
}
