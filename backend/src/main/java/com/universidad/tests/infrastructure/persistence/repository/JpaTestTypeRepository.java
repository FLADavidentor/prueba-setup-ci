package com.universidad.tests.infrastructure.persistence.repository;

import com.universidad.tests.infrastructure.persistence.entity.TestTypeJpaEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTestTypeRepository extends JpaRepository<TestTypeJpaEntity, UUID> {
}
