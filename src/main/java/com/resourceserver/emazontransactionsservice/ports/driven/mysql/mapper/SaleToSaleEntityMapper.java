package com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.SaleReport;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SaleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SaleToSaleEntityMapper {
    SaleEntity toEntity(SaleReport saleReport);
    SaleReport toDomain (SaleEntity saleEntity);
}
