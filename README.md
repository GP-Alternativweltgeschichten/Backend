# 🌍 Spring Boot Backend

## 📌 Projektbeschreibung
Dieses Projekt dient als Backend für die Anwendung Alternativweltgeschichten und bietet APIs zur Verwaltung historischer Karten, Szenarien und thematischer Welten. Zudem unterstützt es KI-basierte Bilderzeugung und Inpainting für historische Rekonstruktionen.

Das Backend basiert auf Spring Boot und folgt bewährten Methoden für die Entwicklung von RESTful APIs. Es integriert eine PostgreSQL-Datenbank, unterstützt Docker-Deployment und enthält eine Swagger UI zur API-Dokumentation.

## 📖 Inhalt
- [Verwendete Technologien](#verwendete-technologien)
- [Voraussetzungen](#voraussetzungen)
- [Installation und Setup](#installation-und-setup)
- [API-Endpunkte](#api-endpunkte)


## 🚀 Verwendete Technologien
Dieses Projekt nutzt folgende Technologien und Frameworks:
- **Java** (Version: 11/17/21)– Haupt programmiersprache
- **Spring Boot** (Version: 2.x/3.x) – Backend-Framework
- **Spring Data JPA** – Datenbankzugriff
- **Hibernate** – ORM für die Datenbankkommunikation
- **PostgreSQL/MySQL** – Unterstützte Datenbanken
- **Swagger for API Documentation** – API-Dokumentation
- **Docker** – Containerisierte Bereitstellung

## ⚙️ Voraussetzungen
Vor dem Start des Projekts sollten folgende Programme installiert sein:
- [Java JDK](https://adoptopenjdk.net/) (Version 11 oder höher)
- [Gradle](https://gradle.org/install/) (zum Bauen des Projekts)
- [Docker](https://www.docker.com/) (falls das Projekt mit Containern ausgeführt wird)

## 📥 Installation und Setup
### 1. Repository klonen
```sh
git clone https://github.com/GP-Alternativweltgeschichten/Backend.git
cd Backend
```

### 2. Umgebungsvariablen konfigurieren
Datenbank- und Anwendungseinstellungen in application.properties und application.yml anpassen.

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

### 3. Anwendung bauen & starten
#### Mit Gradle:
```sh
gradle build
gradle bootRun
```
#### Mit Docker im docker folder:
```sh
docker-compose up --build
```

## 🛠 API Endpunkte
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

Vollständige API-Dokumentation:
Besuche die Swagger UI für interaktive API-Tests:
```
http://localhost:8080/swagger-ui/index.html#/
```

## ...

---
Happy Coding! 🚀

