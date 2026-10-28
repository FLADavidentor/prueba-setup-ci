package com.universidad.tests.controller;

import com.universidad.tests.application.usecase.ListTestTypesUseCase;
import com.universidad.tests.dto.response.TestTypeResponse;
import com.universidad.tests.mapper.TestTypeMapper;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class TestCatalogController {
    private final ListTestTypesUseCase listTestTypes;

    public TestCatalogController(ListTestTypesUseCase listTestTypes) {
        this.listTestTypes = listTestTypes;
    }

    @GetMapping
    public List<TestTypeResponse> list() {
        return listTestTypes.execute().stream().map(TestTypeMapper::toResponse).toList();
    }
}
