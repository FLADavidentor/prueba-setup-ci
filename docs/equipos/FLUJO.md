# Flujo acordado para los equipos

## De principio a fin

1. **Planificación:** Scrum Master crea Product Backlog Item o issue con objetivo, identificador, responsables y fecha.
2. **Definición:** documentadores consolidan RF/RNF, casos de uso, modelo de datos y contratos. Marcan `APROBADO` o dudas; no bloquean trabajos independientes.
3. **Preparación:** desarrolladores crean rama desde `main` y acuerdan cambios de API/DTO y modelos con el integrador.
4. **Implementación:** backend y frontend implementan conjuntamente la historia; cambios SQL van en migraciones inmutables de Flyway.
5. **Verificación:** testers agregan o ejecutan pruebas unitarias, integración y aceptación. Se reúnen evidencias.
6. **Revisión:** se abre PR con referencia de issue, documentación y resultados. GitHub Actions y el integrador revisan.
7. **Integración:** el integrador fusiona tras revisión y visto bueno de testing. `main` queda funcional.
8. **Demostración:** se prueba dentro del sistema completo, se presentan resultados y se registra aprobación funcional.
9. **Traspaso:** el grupo que rota deja decisiones, pendientes, riesgos y estado de PR en `docs/equipos/traspaso-semanal.md`.

## Definition of Ready

Antes de comenzar una historia, debe existir un objetivo comprensible, prioridad, criterios de aceptación comprobables y aprobación de los insumos que necesite. Para un evaluador: **reglas de puntuación y ejemplos esperados** aprobados. Para una pantalla API: contrato REST aprobado. Las tareas puramente técnicas (por ejemplo configurar CI) pueden avanzar sin esperar el modelo completo.

## Definition of Done

Una historia no está terminada por funcionar en una computadora aislada. Debe operar con la plataforma integrada, pasar pruebas y revisión, preservar los módulos anteriores, documentar cambios y quedar demostrable en `main`. Si faltan reglas de puntuación, se marca **bloqueado**, nunca se inventan respuestas.

## Reuniones sugeridas

| Reunión | Participantes | Momento |
| --- | --- | --- |
| Planificación | Scrum Masters y representantes técnicos | Inicio de semana |
| Seguimiento interno | Cada Scrum Master y su grupo | Breve, diario |
| Coordinación entre equipos | Scrum Masters designados | Diario, 10–15 minutos |
| Revisión de contratos | Desarrollo, integración, documentación y testing | Ante cambios API/modelo |
| Demo y retrospectiva | Representantes de todos los equipos | Cierre semanal |

Confirmar el número real de Scrum Masters: una nota de trabajo cita cuatro y el plan académico cinco grupos.
