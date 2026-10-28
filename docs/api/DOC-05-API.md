# DOC-05 Contratos REST

La fuente de verdad para contratos ejecutables es [openapi.yaml](openapi.yaml). No cambiar un endpoint de forma incompatible sin discusión con frontend, integración, documentación y testing.

| Método | Ruta | Propósito | Estado |
| --- | --- | --- | --- |
| GET | `/api/v1/tests` | Listar el catálogo compartido | Implementado como scaffold |
| POST | Por definir | Registrar respuestas y evaluar | Requiere CU, reglas y autenticación aprobadas |
| GET | Por definir | Consultar resultados | Requiere permisos y modelo aprobados |

Para endpoints nuevos definir: método, ruta, parámetros, JSON de entrada/salida, validaciones, códigos HTTP, errores, autorización, RF/CU relacionados, ejemplo y pruebas.
