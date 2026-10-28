# Arquitectura técnica común

El backend es un **monolito modular** con capas y puertos/adaptadores simples. El dominio no depende de frameworks. El objetivo es reutilizar sujetos, periodos, catálogo, evaluaciones, resultados e informes entre cinco pruebas, sin convertir cada test en un microservicio.

## Dirección de dependencias

```text
React → HTTP/JSON → Controller → DTO/Mapper → Application (use case)
                                                   ↓
                                               Domain (reglas)
                                                   ↓
                                       Repository (interfaz de dominio)
                                                   ↑
                                      Infrastructure (adapter JPA) → PostgreSQL
```

Las dependencias del código se dirigen hacia `domain`, aunque la ejecución llegue hasta infraestructura.

| Paquete Java | Responsabilidad | No debe hacer |
| --- | --- | --- |
| `controller/` | Declarar rutas REST, validar entrada y emitir respuesta HTTP. | Calcular puntuaciones o escribir SQL. |
| `dto/` | Definir entradas/salidas públicas, versionables. | Exponer entidades JPA. |
| `mapper/` | Convertir dominio ↔ DTO. | Agregar reglas de negocio. |
| `application/usecase/` | Contratos de operaciones, por ejemplo listar tests o registrar respuesta. | Conocer HTTP o PostgreSQL. |
| `application/service/` | Orquestación de casos de uso. | Contener detalles del servidor web. |
| `application/evaluator/` | Selección del evaluador y coordinación de estrategia por test. | Inventar fórmulas no aprobadas. |
| `domain/model/` | Entidades de negocio y objetos de valor. | Depender de Spring/JPA. |
| `domain/repository/` | Puertos de persistencia. | Importar Spring Data. |
| `domain/exception/` | Errores de reglas de negocio. | Devolver códigos HTTP directamente. |
| `infrastructure/persistence/` | Entidades JPA, repositorios Spring Data y adaptadores. | Decidir reglas de calificación. |
| `infrastructure/security/` | Filtros, acceso y adaptadores de seguridad. | Suplantar una autorización aprobada. |
| `exception/` | Transformar errores del dominio a respuestas HTTP uniformes. | Ocultar errores críticos del sistema. |
| `config/` | Configuración técnica central y beans necesarios. | Aglutinar la lógica de negocio. |

## Extensión a los cinco módulos

Cada test implementará el mismo contrato de evaluación cuando se aprueben datos de entrada, criterios de puntuación y resultados. El motor común seleccionará una estrategia por código (`BFA`, `WEILL`, etc.). Las características compartidas permanecen en componentes comunes, sin cinco copias del registro de usuarios ni cinco esquemas aislados.

## Regla para iniciar una función

- Arquitectura aprobada → configuración de paquete y estructura.
- RF/RNF aprobados → reglas generales.
- Modelo y casos de uso aprobados → entidad y servicio.
- API aprobada → controller, DTO y pantalla.
- Fórmula aprobada con ejemplos → evaluador y pruebas unitarias.
- Validación del tester → integración estable.

Ver diagramas proporcionados en `docs/diagramas/` y decisión [ADR-0001](decisiones/0001-monorepositorio.md).
