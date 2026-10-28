package com.universidad.tests.mapper;

import com.universidad.tests.domain.model.TestType;
import com.universidad.tests.dto.response.TestTypeResponse;

public final class TestTypeMapper {
    private TestTypeMapper() {
    }

    public static TestTypeResponse toResponse(TestType source) {
        return new TestTypeResponse(source.code(), source.name(), source.enabled());
    }
}
