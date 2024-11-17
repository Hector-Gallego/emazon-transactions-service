package com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository;

import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleEntity, Long> {
}
