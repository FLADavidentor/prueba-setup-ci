# Sistema Integrado de Evaluaciones

Monorepositorio académico de **Ingeniería de Software II y Servicios Web**. Un solo producto integra cinco tipos de test con backend Spring Boot, frontend React, base de datos PostgreSQL y documentación compartida. Los grupos rotan entre desarrollo, integración, documentación, pruebas y Scrum Master.

> **Estado del proyecto:** plantilla técnica inicial, no aplicación completa. Ejecuta un catálogo de cinco tipos de prueba, todos deshabilitados. No incluye cuestionarios, fórmulas de calificación, autenticación operativa ni reportes. Esas funcionalidades dependen de requisitos y reglas aprobadas; no se deben inventar.

## Estructura y propósito

| Carpeta | Qué contiene y por qué existe |
| --- | --- |
| `backend/` | Única aplicación Java 17 con Spring Boot, Maven y arquitectura por capas. Centraliza API, reglas y persistencia. |
| `frontend/` | Única aplicación React + TypeScript + Vite. Reutiliza componentes y consume DTOs de la API. |
| `database/migrations/` | Única fuente de migraciones SQL de Flyway. Se empaqueta dentro del JAR de backend. |
| `docs/` | Requisitos, casos de uso, modelo, contratos API, decisiones, evidencias y coordinación. |
| `tests/` | Casos de prueba end-to-end y evidencias transversales; unitarias junto a cada aplicación. |
| `.github/` | Validaciones automáticas, plantillas de incidencias y pull requests. |
| `compose.yaml` | PostgreSQL de desarrollo reproducible para todos los integrantes. |
| `.env.example` | Variables locales sin secretos reales. |

## Requisitos locales

- JDK **17** y Maven **3.6.3 o superior**.
- Node.js **22.12 o superior** y npm.
- Docker Desktop con Docker Compose, o PostgreSQL 17 instalado localmente.
- IntelliJ IDEA, otro IDE compatible y Git.

## Inicio rápido (IntelliJ IDEA, Windows, macOS o Linux)

1. Clonar el repositorio y abrir la **carpeta raíz** `sistema-evaluaciones` en IntelliJ. No abrir `backend/` como un segundo repositorio Git.
2. Copiar `.env.example` a `.env` y modificar la contraseña **solo para desarrollo**. El `.env` no se sube a GitHub.
3. Desde la raíz, ejecutar `docker compose up -d db`.
4. En otra terminal, ejecutar `mvn -f backend/pom.xml spring-boot:run`.
5. En otra terminal, ejecutar `cd frontend`, `npm ci` y `npm run dev`.
6. Abrir `http://localhost:5173`. API de catálogo: `http://localhost:8080/api/v1/tests`; salud: `http://localhost:8080/actuator/health`.

El frontend utiliza el proxy de Vite para solicitar `/api/v1/tests` al backend durante el desarrollo. En producción debe existir un proxy HTTP equivalente, con HTTPS y autenticación aprobada.

Si no tienes Docker, crea una base de datos PostgreSQL con los valores de `.env.example` y levanta directamente el backend. Flyway creará `test_type` al iniciar.

## Verificaciones

```bash
mvn -f backend/pom.xml test
cd frontend
npm ci
npm run typecheck
npm test
npm run build
```

GitHub Actions repite las verificaciones al abrir un pull request. No se incorporan cambios a `main` si no se cumplen la revisión y los criterios del tester.

## Cómo contribuir

Lee [CONTRIBUTING.md](CONTRIBUTING.md), [arquitectura](docs/arquitectura/README.md), [flujo del equipo](docs/equipos/FLUJO.md) y [contrato REST](docs/api/openapi.yaml).

1. Crear una issue/tarea con ID, responsable y criterios de aceptación.
2. Confirmar que el documento correspondiente esté aprobado antes de desarrollar esa parte.
3. Crear rama `feature/semanaN-objetivo`, `fix/...` o `docs/...` desde `main`.
4. Implementar backend, frontend, migración y pruebas en un mismo PR cuando formen una funcionalidad indivisible.
5. Documentar evidencia y pedir revisión. El integrador fusiona después de CI y visto bueno.

**Seguridad:** los endpoints no definidos están bloqueados por defecto. Esta plantilla no autoriza datos personales ni despliegue público; falta diseñar autenticación, roles, gestión de secretos y privacidad. Lee [SECURITY.md](SECURITY.md).

## Aclaraciones de los materiales del curso

- El plan principal y los diagramas establecen **un solo repositorio**; una nota de trabajo menciona dos. Adoptamos el monorepositorio solicitado.
- La referencia a «Flyweight» para versiones de la base de datos parece corresponder a **Flyway**, una herramienta de migraciones. No es lo mismo que el patrón Flyweight. Se eligió Flyway para esta base técnica; el equipo debe confirmar la decisión en el ADR.
- El cronograma principal contempla cinco grupos y cinco módulos. Otras notas mencionan cuatro Scrum Masters; la coordinación debe ajustarse a la distribución real del curso.
