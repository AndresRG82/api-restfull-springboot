# Ejemplos de peticiones (con sofia / Academy)

Este documento contiene ejemplos prácticos para autenticar y consumir la API.

Notas rápidas
- Base URL: http://localhost:8081
- Content-Type: application/json
- Autenticación: JWT en header Authorization: Bearer <accessToken>

## 1) Registro (opcional)

POST /api/auth/register

Body
```json
{
  "username": "sofia",
  "password": "Academy"
}
```

Respuestas
- 200 OK: usuario creado
- 404 Not Found: el registro está deshabilitado (security.auth.registration-enabled: false)
- 400 Bad Request: username ya existe o validación

## 2) Login (obtener tokens)

POST /api/auth/login

Body
```json
{
  "username": "sofia",
  "password": "Academy"
}
```

Respuesta 200
```json
{
  "accessToken": "<jwt>",
  "expiresIn": 900,
  "refreshToken": "<jwt>"
}
```

Errores comunes
- 401 Unauthorized: credenciales inválidas

## 3) Refresh (renovar tokens)

POST /api/auth/refresh

Header
```
Content-Type: text/plain
```

Body (texto plano)
```
<refresh-jwt>
```

Respuesta 200
```json
{
  "accessToken": "<nuevo-access-jwt>",
  "expiresIn": 900,
  "refreshToken": "<nuevo-refresh-jwt>"
}
```

## 4) Crear un libro (ADMIN requerido)

POST /api/books

Headers
```
Authorization: Bearer <access-jwt>
Content-Type: application/json
```

Body
```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

Respuesta 201
```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "978-0132350884"
}
```

## 5) Listar libros (USER o ADMIN)

GET /api/books

Headers
```
Authorization: Bearer <access-jwt>
```

Respuesta 200
```json
[
  {
    "id": 1,
    "title": "Clean Code",
    "author": "Robert C. Martin",
    "isbn": "978-0132350884"
  }
]
```

## 6) Actualizar libro (ADMIN)

PUT /api/books/1

Headers
```
Authorization: Bearer <access-jwt>
Content-Type: application/json
```

Body
```json
{
  "title": "Clean Coder",
  "author": "Robert C. Martin",
  "isbn": "978-0137081073"
}
```

Respuesta 200
```json
{
  "id": 1,
  "title": "Clean Coder",
  "author": "Robert C. Martin",
  "isbn": "978-0137081073"
}
```

## 7) Eliminar libro (ADMIN)

DELETE /api/books/1

Headers
```
Authorization: Bearer <access-jwt>
```

Respuesta 204 (sin cuerpo)
