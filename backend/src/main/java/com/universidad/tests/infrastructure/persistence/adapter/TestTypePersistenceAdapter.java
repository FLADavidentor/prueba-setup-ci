package com.universidad.tests.infrastructure.persistence.adapter;

import com.universidad.tests.domain.model.TestType;
import com.universidad.tests.domain.repository.TestTypeRepository;
import com.universidad.tests.infrastructure.persistence.entity.TestTypeJpaEntity;
import com.universidad.tests.infrastructure.persistence.repository.JpaTestTypeRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TestTypePersistenceAdapter implements TestTypeRepository {
    private final JpaTestTypeRepository jpaRepository;

    public TestTypePersistenceAdapter(JpaTestTypeRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<TestType> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).toList();
    }

    private TestType toDomain(TestTypeJpaEntity entity) {
        return new TestType(entity.getId(), entity.getCode(), entity.getName(),
                entity.getDisplayOrder(), entity.isEnabled());
    }
}
