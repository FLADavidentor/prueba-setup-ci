# Seguridad y privacidad

Este repositorio es una **base académica**, no un sistema autorizado para almacenar resultados psicológicos ni información real de personas.

La configuración inicial permite únicamente lectura pública del catálogo de tipos de test y estado de salud; deniega rutas no implementadas. No existe inicio de sesión funcional, autorización por roles, gestión de consentimientos ni política de conservación. CSRF está desactivado en la API de arranque sin sesiones/cookies; revisarlo al decidir la autenticación.

Antes de habilitar cuestionarios o cargar datos de usuarios:

1. Aprobar roles (administrador, aplicador, evaluado, etc.) y permisos por operación.
2. Implementar autenticación y autorización, sin credenciales embebidas.
3. Definir requisitos de protección de datos, consentimiento y retención según el ámbito aplicable.
4. Cifrar conexiones, gestionar secretos por entorno y registrar eventos sin exponer respuestas sensibles.
5. Diseñar pruebas de acceso, errores, validaciones, protección de datos y autorización.
6. Revisar la configuración de CORS, CSRF, cookies y rate limiting según la solución de seguridad definitiva.

Reportar vulnerabilidades directamente al docente y responsables designados, sin publicar datos o exploit funcional en incidencias abiertas.
