# Base de datos y migraciones

La base de datos de desarrollo es PostgreSQL. Los scripts **reales** de Flyway viven únicamente en `database/migrations/`; Maven los incorpora al JAR en `db/migration` durante la compilación. No duplicar archivos SQL en `backend/src/main/resources`.

- `V1__create_test_type.sql`: crea el catálogo transversal de cinco pruebas en estado deshabilitado; no implementa evaluaciones.
- `V2__descripcion.sql`, `V3__descripcion.sql`: cambios futuros, sujetos a aprobación del modelo DOC-03.
- No editar una migración que ya se ejecutó en un entorno compartido. Crear otra versión.
- El equipo documentador registra el cambio de esquema y el integrador verifica que las pruebas anteriores sigan funcionando.
- Nunca insertar datos reales de estudiantes o resultados psicológicos en migraciones de ejemplo.

**Pendiente de validación funcional:** definir entidades de sujetos, períodos, preguntas, intentos, resultados y reportes con sus cardinalidades. No están modeladas de forma arbitraria en esta plantilla.
