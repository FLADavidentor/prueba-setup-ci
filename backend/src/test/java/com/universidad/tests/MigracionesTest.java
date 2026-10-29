package com.universidad.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MigracionesTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Test
    void flywayAplicaLasMigracionesDeDatabaseMigrations() {
        Integer aplicadas = jdbc.queryForObject(
                "select count(*) from flyway_schema_history where success", Integer.class);
        Integer tabla = jdbc.queryForObject(
                "select count(*) from information_schema.tables where table_name = 'prueba_setup'", Integer.class);
        assertThat(aplicadas).isPositive();
        assertThat(tabla).isEqualTo(1);
    }
}
