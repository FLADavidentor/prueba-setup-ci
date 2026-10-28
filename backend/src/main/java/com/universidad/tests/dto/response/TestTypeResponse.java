package com.universidad.tests.dto.response;

/** Contrato público: evita exponer entidades JPA directamente. */
public record TestTypeResponse(String code, String name, boolean enabled) {
}
