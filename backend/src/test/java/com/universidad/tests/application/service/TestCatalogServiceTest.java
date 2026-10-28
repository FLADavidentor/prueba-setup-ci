package com.universidad.tests.application.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.universidad.tests.domain.model.TestType;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class TestCatalogServiceTest {
    @Test
    void ordersTestTypesByReleasePlan() {
        var weill = new TestType(UUID.randomUUID(), "WEILL", "Inteligencia de Weill", 2, false);
        var bfa = new TestType(UUID.randomUUID(), "BFA", "Batería Factorial de Aptitudes", 1, false);
        var service = new TestCatalogService(() -> List.of(weill, bfa));

        assertThat(service.execute()).extracting(TestType::code)
                .containsExactly("BFA", "WEILL");
    }
}
