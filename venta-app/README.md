# Venta App

Este proyecto es una aplicación de gestión de ventas desarrollada en Java utilizando Spring Boot. A continuación se detallan las características y la estructura del proyecto.

## Estructura del Proyecto

```
venta-app
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── ventaapp
│   │   │               ├── controller
│   │   │               │   └── VentaController.java
│   │   │               ├── model
│   │   │               │   └── Venta.java
│   │   │               ├── dto
│   │   │               │   └── VentaDTO.java
│   │   │               ├── repository
│   │   │               │   └── VentaRepository.java
│   │   │               ├── service
│   │   │               │   ├── VentaService.java
│   │   │               │   └── impl
│   │   │               │       └── VentaServiceImpl.java
│   │   │               └── VentaApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── ventaapp
│                       └── VentaControllerTest.java
├── pom.xml
├── .gitignore
└── README.md
```

## Requisitos

- Java 11 o superior
- Maven

## Configuración

1. Clona el repositorio:
   ```
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Navega al directorio del proyecto:
   ```
   cd venta-app
   ```

3. Compila el proyecto utilizando Maven:
   ```
   mvn clean install
   ```

4. Configura la conexión a la base de datos en `src/main/resources/application.properties`.

## Ejecución

Para ejecutar la aplicación, utiliza el siguiente comando:
```
mvn spring-boot:run
```

## Pruebas

Las pruebas unitarias están ubicadas en `src/test/java/com/example/ventaapp/VentaControllerTest.java`. Para ejecutar las pruebas, utiliza:
```
mvn test
```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o envía un pull request para discutir cambios.

## Licencia

Este proyecto está bajo la Licencia MIT.