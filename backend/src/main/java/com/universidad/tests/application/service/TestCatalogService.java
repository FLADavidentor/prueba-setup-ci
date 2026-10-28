package com.universidad.tests.application.service;

import com.universidad.tests.application.usecase.ListTestTypesUseCase;
import com.universidad.tests.domain.model.TestType;
import com.universidad.tests.domain.repository.TestTypeRepository;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TestCatalogService implements ListTestTypesUseCase {
    private final TestTypeRepository repository;

    public TestCatalogService(TestTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TestType> execute() {
        return repository.findAll().stream()
                .sorted(Comparator.comparingInt(TestType::displayOrder))
                .toList();
    }
}
