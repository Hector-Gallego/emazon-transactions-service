package com.resourceserver.emazontransactionsservice.ports.driven.mysql.mapper;

import com.resourceserver.emazontransactionsservice.domain.model.Supply;
import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SupplyToSupplyEntityMapper {
    SupplyEntity toEntity(Supply supply);

}
