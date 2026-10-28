# Plan de pruebas y evidencia

## Matriz mínima por historia

| ID de prueba | RF/CU | Escenario | Entrada | Resultado esperado | Resultado real | Estado | Evidencia |
| --- | --- | --- | --- | --- | --- | --- | --- |
| PR-001 | RF-001 | Solicitar catálogo de tests | GET `/api/v1/tests` | HTTP 200 y cinco registros | Por ejecutar con PostgreSQL | Pendiente | Por enlazar |

## Criterios de aceptación del sprint

1. Visualizar y responder preguntas cuando el módulo esté implementado.
2. Procesar respuestas correctamente y calcular según reglas aprobadas.
3. Guardar resultados en PostgreSQL.
4. API REST y comunicación React–Spring Boot operativas.
5. Pruebas unitarias, integración, regresión y aceptación satisfactorias.
6. Documentación y tareas actualizadas.
7. Sin regresiones en tests anteriores.

En el scaffold solo se puede verificar catálogo, compilación y parte de la estructura; **no declarar BFA terminado**.
