# Patrones Utilizados

## Patrón Adapter
El patrón Adapter se utilizó para desacoplar la lógica de negocio de la infraestructura externa.
Permite que los casos de uso trabajen mediante interfaces (puertos) sin depender directamente de tecnologías específicas.

- Implementaciones usadas:
1. CuentaRepositoryAdapter
Adapta la persistencia JPA hacia el puerto del dominio.
Convierte operaciones de base de datos en métodos entendibles por la aplicación.
2. ConsoleNotificationAdapter
Adapta el sistema de notificaciones.
Permite enviar mensajes sin que el dominio conozca cómo se implementan.
- Beneficio
Facilita cambiar tecnologías sin afectar la lógica de negocio.
Mejora el desacoplamiento y mantenibilidad.

## Patrón Singleton
El patrón Singleton se aplica mediante los componentes administrados por Spring Boot (@Service, @Repository, @Component).

- Implementación usada:
Los casos de uso y adaptadores son instanciados una sola vez por el contenedor Spring.
- Beneficio
Evita múltiples instancias innecesarias.
Optimiza memoria y administración de dependencias.
Centraliza el acceso a servicios compartidos.

