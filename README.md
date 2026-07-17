# Regalería París - Sistema de Stock

Sistema de gestión de stock para una regalería, con backend en Spring Boot (API REST) y frontend en HTML/CSS/JS.

## Estructura del proyecto
## Tecnologías

- **Backend:** Java, Spring Boot 3.5.3, Maven
- **Frontend:** HTML, CSS, JavaScript

## Estado actual

El backend actualmente usa una **lista en memoria** como almacenamiento (no persiste entre reinicios). La conexión a una base de datos real (MySQL/PostgreSQL) está planeada como próximo paso.

## Endpoints disponibles

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| GET | `/productos` | Lista todos los productos |
| POST | `/productos` | Crea un nuevo producto |
| PUT | `/productos` | Actualiza un producto completo |
| PATCH | `/productos` | Actualiza parcialmente un producto |
| DELETE | `/productos/{id}` | Elimina un producto por id |


## Próximos pasos
- Conexión a base de datos real (Spring Data JPA)
- Sistema de login / autenticación
- Manejo de errores centralizado (`@ControllerAdvice`)
- Deploy del backend a un servicio en la nube (Render/Railway)
