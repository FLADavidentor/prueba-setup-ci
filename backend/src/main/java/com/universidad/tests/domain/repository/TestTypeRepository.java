package com.universidad.tests.domain.repository;

import com.universidad.tests.domain.model.TestType;
import java.util.List;

/** Puerto de dominio: no conoce Spring Data ni PostgreSQL. */
public interface TestTypeRepository {
    List<TestType> findAll();
}
