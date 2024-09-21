package com.resourceserver.emazontransactionsservice.ports.driven.mysql.repository;

import com.resourceserver.emazontransactionsservice.ports.driven.mysql.entity.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
