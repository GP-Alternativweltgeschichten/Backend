# Spring Boot Backend

## 📌 Project Overview
A brief description of the project, what it does, and the technologies used.

## 🚀 Technologies Used
- **Java** (Version: 11/17/21)
- **Spring Boot** (Version: 2.x/3.x)
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL/MySQL**
- **Swagger for API Documentation**
- **Docker**

## ⚙️ Prerequisites
Ensure you have the following installed:
- [Java JDK](https://adoptopenjdk.net/) (Version 11+ recommended)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/) for containerized deployment

## 📥 Installation & Setup
### 1. Clone the Repository
```sh
git clone https://github.com/GP-Alternativweltgeschichten/Backend.git
cd Backend
```

### 2. Configure Environment Variables
Modify `application.properties` and `application.yml` with the correct database and application settings.

`src/main/resources/application.properties`:
```properties
spring.application.name=Backend
spring.jackson.property-naming-strategy=SNAKE_CASE

spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres
spring.datasource.username=postgres
spring.datasource.password=postgres

spring.jpa.hibernate.ddl-auto= update
```
`src/main/resources/application.yml`:
```properties
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/postgres
    driver-class-name: org.postgresql.Driver
    username: postgres
    password: postgres
  jpa:
    database: postgresql
    properties:
      hibernate:
        format_sql: true
    show-sql: false
  mvc:
    pathmatch:
      matching-strategy: ant_path_matcher
management:
  endpoints:
    enabled-by-default: true
```

### 3. Build & Run the Application
#### Using Gradle:
```sh
gradle ...
```
#### Using Docker in docker folder:
```sh
docker-compose up --build
```

## 🛠 API Endpoints
### Old Maps
- `GET /oldmaps` - Get all old maps
- `GET /oldmaps/{id}` - Get an old map by id
- `GET /oldmaps/{id}/map` - Get the map for one old map
- `POST /oldmaps` - Save one old map
- `PUT /oldmaps` - Edit one old map
- `DELETE /oldmaps/{id}` - Delete one old map by id

### Propmting
- `POST /prompting/text` - Generate new image from text
- `POST /prompting/inpainting` - Generate new image from inpainting

### Sceanrios
- `GET /scenarios` - Get all scenarios
- `GET /scenarios/{id}` - Get an scenario by id
- `GET /scenarios/{id}/map` - Get the map for one scenario
- `POST /scenarios` - Save ine scenario
- `PUT /scenarios` - Edit one scenario
- `DELETE /scenarios/{id}` - Delete one scenario by id

### Thematic Worlds
- `GET /thematicworlds` - Get all thematic worlds

For complete API documentation, visit Swagger UI:
```
http://localhost:8080/swagger-ui/index.html#/
```

## ...

---
Happy Coding! 🚀

