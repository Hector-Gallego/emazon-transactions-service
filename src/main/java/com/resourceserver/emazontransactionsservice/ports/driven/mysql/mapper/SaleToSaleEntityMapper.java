package com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.Sale;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SaleToSaleEntityMapper {
    SaleEntity toEntity(Sale sale);
    Sale toDomain (SaleEntity saleEntity);
}
