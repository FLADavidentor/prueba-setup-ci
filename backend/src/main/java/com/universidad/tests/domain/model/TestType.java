package com.universidad.tests.domain.model;

import java.util.UUID;

/** Tipo de prueba compartido por todos los módulos. No incluye reglas de puntuación. */
public record TestType(UUID id, String code, String name, int displayOrder, boolean enabled) {
}
