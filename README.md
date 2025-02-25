# 🌍 Spring Boot Backend

## 📌 Projektbeschreibung
Dieses Projekt dient als Backend für die Anwendung Alternativweltgeschichten und bietet APIs zur Verwaltung historischer Karten, Szenarien und thematischer Welten. Zudem unterstützt es KI-basierte Bilderzeugung und Inpainting für historische Rekonstruktionen.

Das Backend basiert auf Spring Boot und folgt bewährten Methoden für die Entwicklung von RESTful APIs. Es integriert eine PostgreSQL-Datenbank, unterstützt Docker-Deployment und enthält eine Swagger UI zur API-Dokumentation.

## 📖 Inhalt
- [Verwendete Technologien](#verwendete-technologien)
- [Voraussetzungen](#voraussetzungen)
- [Installation und Setup](#installation-und-setup)
- [API-Endpunkte](#api-endpunkte)
- [Datenstruktur](#datenstruktur)

## 🚀 Verwendete Technologien
Dieses Projekt nutzt folgende Technologien und Frameworks:
- **Java** (Version: 17)– Haupt programmiersprache
- **Spring Boot** (Version: 3.4) – Backend-Framework
- **Spring Data JPA** – Datenbankzugriff
- **Hibernate** – ORM für die Datenbankkommunikation
- **PostgreSQL** – Unterstützte Datenbanken
- **Swagger für API Dokumentation** – API-Dokumentation
- **Docker** – Containerisierte Bereitstellung

## ⚙️ Voraussetzungen
Vor dem Start des Projekts sollten folgende Programme installiert sein:
- [Java JDK](https://adoptopenjdk.net/) (Version 17)
- [Gradle](https://gradle.org/install/) (zum Bauen des Projekts)
- [Docker](https://www.docker.com/) (da das Projekt mit Containern ausgeführt wird)

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
- `GET /oldmaps` - Alle alten Karten abrufen
- `GET /oldmaps/{id}` - Eine alte Karte anhand der ID abrufen
- `GET /oldmaps/{id}/map` -Die Karte zu einer alten Karte abrufen
- `POST /oldmaps` - Eine alte Karte speichern
- `PUT /oldmaps` - Eine alte Karte bearbeiten
- `DELETE /oldmaps/{id}` - Eine alte Karte anhand der ID löschen

### Propmting
- `POST /prompting/text` - Ein neues Bild aus Text generieren
- `POST /prompting/inpainting` - Ein neues Bild per Inpainting generieren

### Sceanrios
- `GET /scenarios` - Alle Szenarien abrufen
- `GET /scenarios/{id}` - Ein Szenario anhand der ID abrufen
- `GET /scenarios/{id}/map` - Die Karte zu einem Szenario abrufen
- `POST /scenarios` - Ein Szenario speichern
- `PUT /scenarios` - Ein Szenario bearbeiten
- `DELETE /scenarios/{id}` - Ein Szenario anhand der ID löschen

### Thematic Worlds
- `GET /thematicworlds` - Alle thematischen Welten abrufen

Vollständige API-Dokumentation:
Besuche die Swagger UI für interaktive API-Tests:
```
http://localhost:8080/swagger-ui/index.html#/
```

## 🗃️ Datenstruktur
Das Backend verwendet eine relationale Datenbank (PostgreSQL) zur Speicherung und Verwaltung der Daten. Die Datenstruktur ist auf eine effiziente Verwaltung historischer Karten, Szenarien und thematischer Welten ausgelegt und folgt den Prinzipien der Normalisierung zur Vermeidung redundanter Daten.
### Hauptentitäten
1. OldMap
  - Repräsentiert historische Karten mit Metadaten und Bildinformationen.
  - Felder:
    - id (Integer, Primary Key) – Eindeutige Identifikation der Karte
    - name (Varchar(255)) – Name der historischen Karte
    - image (Bytea) – Bild der Karte im Binärformat
    - date_of_map (Text) – Historisches Datum der Karte (z. B. Jahr oder Epoche)
    - editable (Boolean) – Gibt an, ob die Karte bearbeitet werden kann
    - visible (Boolean) – Gibt an, ob die Karte öffentlich sichtbar ist
    - created_at (Timestamp) – Erstellungsdatum
    - updated_at (Timestamp) – Datum der letzten Aktualisierung
2. Scenario
  - Beschreibt alternative historische Szenarien, die auf den alten Karten basieren.
  - Felder:
    - id (Integer, Primary Key) – Eindeutige Identifikation des Szenarios
    - name (Varchar(255)) – Name des Szenarios
    - image (Bytea) – Bild zum Szenario im Binärformat
    - description (Text) – Detaillierte Beschreibung und historische Annahmen
    - editable (Boolean) – Gibt an, ob das Szenario bearbeitet werden kann
    - visible (Boolean) – Gibt an, ob das Szenario öffentlich sichtbar ist
    - created_at (Timestamp) – Erstellungsdatum
    - updated_at (Timestamp) – Datum der letzten Aktualisierung
### Datenbankmodell
![postgres@localhost](https://github.com/user-attachments/assets/62e2cd6c-1138-4550-b51e-1e9608eab116)

## ...

---
Happy Coding! 🚀

