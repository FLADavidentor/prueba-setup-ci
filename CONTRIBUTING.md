# Contribución y gobierno del repositorio

## Reglas obligatorias

1. `main` siempre debe poder compilar y representar una versión integrada. Sin commits directos una vez habilitada la protección.
2. Una rama por issue: `feature/sem1-bfa-012-formulario`, `fix/sem2-validacion` o `docs/doc-05-api-bfa`.
3. Usar commits descriptivos (`feat:`, `fix:`, `docs:`, `test:`, `chore:`).
4. Toda funcionalidad necesita criterio de aceptación y trazabilidad a RF, CU y contrato API cuando aplique.
5. El PR indica qué cambia, por qué, cómo se probó y quién validó. Los cambios de contrato requieren coordinación frontend/backend.
6. No modificar migraciones Flyway ejecutadas. Agregar otra versión y verificar compatibilidad.
7. Nunca subir contraseñas, tokens, identificaciones personales, resultados reales ni archivos `.env`.
8. Los integradores aprueban la fusión; testers validan aceptación y documentadores actualizan fuentes. Los responsables cambian con la rotación.

## Revisión mínima de un pull request

- [ ] Compila el backend y pasan sus pruebas.
- [ ] Compila el frontend, pasan sus pruebas y tipos.
- [ ] Contrato DTO/JSON y errores documentados si cambian.
- [ ] Migración SQL incluida, probada y compatible, si cambia la persistencia.
- [ ] El código mantiene el sentido de dependencia entre capas.
- [ ] Requisitos, casos de uso y evidencia vinculados.
- [ ] El tester aprobó el comportamiento integrado o documentó el bloqueo.

## Configuración inicial en GitHub

Ir a **Settings → Rules → Rulesets** (o protección de ramas) y configurar `main` para exigir pull requests, al menos una revisión y las verificaciones `backend-tests` y `frontend-tests` una vez aparezcan. Deshabilitar force-push y eliminación de rama. Configurar permisos del equipo de manera que solo los integradores designados puedan fusionar.

Cuando se conozcan los usuarios de GitHub, copiar `.github/CODEOWNERS.example` a `.github/CODEOWNERS` y sustituir los marcadores por cuentas reales. No activar propietarios ficticios.

No hace falta rama `develop` al inicio: ramas cortas, integración frecuente y `main` protegida reducen confusión en equipos rotativos.
