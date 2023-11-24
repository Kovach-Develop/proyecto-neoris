# proyecto-neoris

Para probar el proyecto en Postman, sigue los siguientes pasos:

## Obtener Token de Acceso

- **URL para Obtener Token:**
  ```
  http://localhost:8080/api/usuarios/token
  ```
- **Método:** `GET`

### Respuestas:

- **Código de Estado HTTP:**
    - En caso de éxito: `200 OK`

- **Cuerpo de Respuesta (En caso de éxito):**
  ```json
  {
    "token": "tu_token_de_acceso"
  }
  ```

## Crear Usuario

- **URL para Crear Usuario:**
  ```
  http://localhost:8080/api/usuarios/registro
  ```

- **Método:** `POST`

### Cabecera de Autorización:

- **Tipo:** `Bearer Token`
- **Token:** `tu_token_de_acceso`

### Cuerpo de Solicitud:

```json
{
  "name": "Juan Rodriguez",
  "email": "juan31119@rodriguez.org",
  "password": "18711578!",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}
```

### Respuestas:

- **Código de Estado HTTP:**
    - En caso de éxito: `200 OK`

- **Cuerpo de Respuesta (En caso de éxito):**
  ```json
  {
    "id": "uuid_generado",
    "created": "fecha_creacion",
    "modified": "fecha_ultima_actualizacion",
    "last_login": "fecha_ultimo_ingreso",
    "token": "token_de_acceso",
    "isactive": true
  }
  ```

- **Errores:**
    - Correo ya registrado:
      ```json
      {"mensaje": "El correo ya registrado"}
      ```
    - Error de formato de correo:
      ```json
      {"mensaje": "Formato de correo incorrecto. Debe seguir el formato aaaaaaa@dominio.cl"}
      ```
    - Error de formato de contraseña:
      ```json
      {"mensaje": "Formato de contraseña incorrecto. Debe seguir la expresión regular especificada."}
      ```

¡Ahora puedes probar tu proyecto utilizando Postman! Asegúrate de seguir las instrucciones proporcionadas y de tener el token de acceso al realizar la creación de usuarios.

# Evaluación: JAVA - Creación de API RESTful de Usuarios

## Descripción del Proyecto

Desarrolla una aplicación que exponga una API RESTful para la creación de usuarios. Todos los endpoints deben aceptar y retornar únicamente JSON, incluso para los mensajes de error. Todos los mensajes deben seguir el formato:

```json
{"mensaje": "mensaje de error"}
```

### Registro de Usuario

- **Endpoint:** `/registro`
- **Método:** `POST`
- **Descripción:** Este endpoint recibe un usuario con los campos "nombre", "correo", "contraseña" y un listado de objetos "teléfono" siguiendo el formato especificado.

  **Ejemplo de Cuerpo de Solicitud:**
  ```json
  {
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "hunter2",
    "phones": [
      {
        "number": "1234567",
        "citycode": "1",
        "countrycode": "57"
      }
    ]
  }
  ```

- **Respuestas:**
    - **Código de Estado HTTP:**
        - En caso de éxito: `200 OK`
        - En caso de error: Código de error correspondiente.
    - **Cuerpo de Respuesta (En caso de éxito):**
      ```json
      {
        "id": "uuid_generado",
        "created": "fecha_creacion",
        "modified": "fecha_ultima_actualizacion",
        "last_login": "fecha_ultimo_ingreso",
        "token": "token_de_acceso",
        "isactive": true
      }
      ```
    - **Errores:**
        - Correo ya registrado:
          ```json
          {"mensaje": "El correo ya registrado"}
          ```
        - Error de formato de correo:
          ```json
          {"mensaje": "Formato de correo incorrecto. Debe seguir el formato aaaaaaa@dominio.cl"}
          ```
        - Error de formato de contraseña:
          ```json
          {"mensaje": "Formato de contraseña incorrecto. Debe seguir la expresión regular especificada."}
          ```

### Requisitos del Proyecto

- **Plazo:** 2 días. En caso de inconvenientes con el tiempo, comunicarse.
- **Banco de Datos:** En memoria (Ejemplo: HSQLDB o H2).
- **Proceso de Build:** Gradle o Maven.
- **Persistencia:** JPA (Ejemplo: EclipseLink, Hibernate u OpenJPA).
- **Framework:** SpringBoot.
- **Versión de Java:** 8 o superior.
- **Entrega:** Repositorio público en GitHub o Bitbucket con código fuente y script de creación de la base de datos.
- **Documentación Adicional:**
    - README explicando cómo probar la aplicación.
    - Diagrama de la solución.

### Requisitos Opcionales

- JWT como token.
- Pruebas Unitarias.
- Swagger para la documentación de la API.