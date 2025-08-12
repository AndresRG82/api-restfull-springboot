## Flujo de Spring Security 

1. **El usuario envía credenciales a `/api/auth/login`.**
2. **El controlador autentica usando `AuthenticationManager` y, si es correcto, genera un JWT.**
3. **El cliente usa el JWT en el header `Authorization: Bearer <token>` para acceder a endpoints protegidos.**
4. **Un filtro (`JwtAuthenticationFilter`) valida el token en cada request y coloca el usuario en el contexto de seguridad.**
5. **Las reglas de acceso (por rol) se definen en `SecurityConfig`.**
6. **Si el token es inválido o el usuario no tiene permisos, se responde con error JSON estándar.**