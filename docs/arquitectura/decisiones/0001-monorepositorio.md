# ADR-0001 Monorepositorio y monolito modular

**Estado:** Propuesto para aprobación del responsable técnico y del curso.

## Contexto

El plan requiere cinco pruebas implementadas incrementalmente, equipos rotativos y una sola entrega final. Aparece una nota informal que sugiere dos repositorios, pero contradice el principio de producto único y la instrucción actual.

## Decisión

- Un repositorio `sistema-evaluaciones` con `backend/`, `frontend/`, `database/`, `docs/`, `tests/` y `.github/`.
- Un backend Spring Boot Java 17 con una API REST versionada y capas Controller, Application, Domain e Infrastructure.
- Un frontend React TypeScript con funcionalidades por módulo y componentes compartidos.
- Una base de datos PostgreSQL con migraciones Flyway inmutables una vez desplegadas.
- Un `main` protegido, ramas cortas, PR y CI antes de fusionar.

## Consecuencias

**Beneficios:** interfaces consistentes, coordinación simultánea, pruebas integradas, cambios atómicos de API/UI/SQL y conocimiento compartido en cada rotación.

**Costos:** un cambio de contrato puede afectar a varios equipos; se exigen revisión conjunta, convenciones y regresión.

**Pendientes:** confirmar nombre, responsables de aprobación, estrategia de autenticación y la corrección `Flyweight` → `Flyway` del mockup.
