## Flujo de Spring Security 

1. **El usuario envía credenciales a `/api/auth/login`.**
2. **El controlador autentica usando `AuthenticationManager` y, si es correcto, genera un JWT.**
3. **El cliente usa el JWT en el header `Authorization: Bearer <token>` para acceder a endpoints protegidos.**
4. **Un filtro (`JwtAuthenticationFilter`) valida el token en cada request y coloca el usuario en el contexto de seguridad.**
5. **Las reglas de acceso (por rol) se definen en `SecurityConfig`.**
6. **Si el token es inválido o el usuario no tiene permisos, se responde con error JSON estándar.**


##  

- access-ttl: 15m
- refresh-ttl: 7d

## Ejecutar la aplicación (Windows PowerShell)

Desde la carpeta raíz del proyecto puedes usar uno de estos comandos:

```powershell
.\mvnw spring-boot:run
```

Con Maven instalado globalmente:

```powershell
mvn spring-boot:run
```

Con Gradle (si tuvieses un wrapper de Gradle):

```powershell
.\gradlew.bat bootRun
```

Construir el JAR y ejecutar:

```powershell
.\mvnw clean package -DskipTests
java -jar target\*.jar
```

Por defecto la aplicación corre en http://localhost:8080 salvo que cambies el puerto en `src/main/resources/application.yaml`.