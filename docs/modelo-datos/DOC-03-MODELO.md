# DOC-03 Modelo de datos

**Estado:** Solo tabla técnica `test_type` aprobable como base. Las entidades del dominio aún requieren análisis.

| Entidad | Propósito | Atributos | Relaciones | Fuente y estado |
| --- | --- | --- | --- | --- |
| `test_type` | Catálogo de tipos de evaluación | `id`, `code`, `name`, `display_order`, `enabled` | Por definir | Propuesta técnica inicial |

Por levantar: Sujetos, Periodos, Preguntas, Opciones, Respuestas, Intentos, Resultados e Informes. Definir cardinalidades, restricciones, acceso y retención con documentación funcional antes de implementar JPA/migraciones adicionales.
