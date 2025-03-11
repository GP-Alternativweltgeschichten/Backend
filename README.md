# 🌍 Spring Boot Backend

## 📌 Beschreibung
Dieses Anwendung dient als Backend für das Projekt Alternativweltgeschichten und bietet APIs zur Verwaltung historischer Karten, Szenarien und thematischer Welten. Zudem unterstützt es KI-basierte Bilderzeugung und Inpainting für historische Rekonstruktionen.

Das Backend basiert auf Spring Boot und folgt bewährten Methoden für die Entwicklung von RESTful APIs. Es integriert eine PostgreSQL-Datenbank, unterstützt Docker-Deployment und enthält eine Swagger UI zur API-Dokumentation.

## 📖 Inhalt
- [Verwendete Technologien](#-verwendete-technologien)
- [Voraussetzungen](#%EF%B8%8F-voraussetzungen)
- [Installation und Setup](#-installation-und-setup)
- [API-Endpunkte](#-api-endpunkte)
- [Datenstruktur](#%EF%B8%8F-datenstruktur)
- [Projektstruktur](#-projektstruktur)

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

### Prompting
- `POST /prompting/text` - Ein neues Bild aus Text generieren
- `POST /prompting/inpainting` - Ein neues Bild per Inpainting generieren

### Scenarios
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
**OldMap**
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

**Scenario**
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
### Weitere Entität
**ThematicWorld**
  - Beschreibt eine alte Karte oder ein Szenario, das für den Besucher sichtbar sein soll
  - Felder:
    - id (Integer, Primary Key) – Eindeutige Identifikation der Themenwelt
    - name (Varchar(255)) – Name der Themenwelt
    - description (Text) – Detaillierte Beschreibung und historische Annahmen
    - image (Bytea) – Bild zur Themenwelt im Binärformat
    - editable (Boolean) – Gibt an, ob die Themenwelt bearbeitet werden kann
    - visible (Boolean) – Gibt an, ob die Themenwelt öffentlich sichtbar ist

**PromptingDTO**
  - Repräsentiert den Prompt der aus den Daten des Frontends an die KI gesendet wird
  - Felder
    - promt (Text) - ...
    - image (Text) - ...
    - mask (Text) - ...
    - realism (Interger) - ...

## 🧱 Projektstruktur
Das Projekt folgt einem modularen Paket-Design, bei dem die Funktionalitäten in Domänen aufgeteilt und klar voneinander getrennt sind. Diese Struktur fördert Wartbarkeit, Erweiterbarkeit und eine klare Trennung der Verantwortlichkeiten.
### Übersicht über die Pakete
Das Projekt ist in folgende Domänenpakete unterteilt:
- oldmaps: Verwaltung von alten Karten
- scenario: Verwaltung von Szenarien
- prompting: Verarbeitung von Texteingaben zur Bildgenerierung
- thematicworlds: Verwaltung von thematischen Welten
Jedes Paket enthält spezifische Komponenten, um den Clean Architecture-Ansatz und die Schichtenarchitektur (Layered Architecture) umzusetzen.
### Aufbau der Schichten
Für jede Domäne (oldmaps, scenario, prompting, thematicworlds) sind die folgenden Schichten implementiert:

**Entity** (OldMap, Scenario, ThematicWorld)
  - Repräsentiert die Datenbankstruktur und spiegelt die Tabellen wider.
  - Verwendet JPA-Annotationen zur Definition von Persistenz-Mapping.
  - Wird für die Kommunikation mit der Datenbank verwendet.

**DTO** (OldMapDTO, ScenarioDTO, PromptingDTO)
  - Definiert die Datenstruktur für Anfragen und Antworten der REST-API.
  - Verhindert direkte Kopplung der Entitäten an externe Schnittstellen.

**Mapper** (OldMapMapper, ScenarioMapper)
  - Konvertiert zwischen Entity und DTO.
  - Verwendet MapStruct zur Generierung von Mapping-Code zur Compile-Zeit.

**Repository** (OldMapRepo, ScenarioRepo)
  - Schnittstelle zur Datenbankkommunikation mit Spring Data JPA.
  - Unterstützt CRUD-Operationen durch vordefinierte Methoden (findAll, findById, save, deleteById).

**Service** (OldMapService, ScenarioService, PromptingService, ThematicWorldsService)
  - Enthält die Geschäftslogik der Anwendung.
  - Koordiniert die Kommunikation zwischen Repository, Mapper und Controller.

**Controller** (OldMapController, ScenarioController, PromptingController, ThematicWorldsController)
  - Stellt die REST-API Endpunkte bereit.
  - Verarbeitet HTTP-Anfragen (GET, POST, PUT, DELETE) und gibt HTTP-Antworten zurück.
  - Delegiert die Geschäftslogik an den entsprechenden Service.
### Kommunikation zwischen den Schichten
Der Controller empfängt die Anfragen und ruft die entsprechenden Methoden im Service auf.

Der Service nutzt den Mapper, um die Daten zwischen DTO und Entity zu konvertieren und verwendet das Repository zur Datenbankkommunikation.

Das Repository führt die CRUD-Operationen aus und gibt die Daten an den Service zurück.

Der Service bereitet die Daten für den Controller auf, der sie als HTTP-Response zurückgibt.
### Vorteile und Begründung
**Modularität**: Klare Trennung der Domänen (oldmaps, scenario, prompting, thematicworlds) erhöht die Übersichtlichkeit und fördert die Wartbarkeit.

**Wiederverwendbarkeit und Testbarkeit**: Isolierte Geschäftslogik in den Services und wiederverwendbare Mapper erleichtern Unit-Tests.

**Erweiterbarkeit**: Neue Features können durch Hinzufügen von Klassen in den jeweiligen Domänenpaketen leicht integriert werden.

**Klarer Verantwortungsbereich**: Durch die Schichtenarchitektur bleibt der Code sauber und strukturiert.
### Verzeichnisstruktur
```text
com.be.backend
│
├── oldmaps
│   ├── OldMap.java (Entity)
│   ├── OldMapDTO.java (DTO)
│   ├── OldMapMapper.java (Mapper)
│   ├── OldMapRepo.java (Repository)
│   ├── OldMapService.java (Service)
│   └── OldMapController.java (Controller)
│
├── scenario
│   ├── Scenario.java
│   ├── ScenarioDTO.java
│   ├── ScenarioMapper.java
│   ├── ScenarioRepo.java
│   └── ScenarioService.java
│
├── prompting
│   ├── PromptingDTO.java
│   ├── PromptingService.java
│   └── PromptingController.java
│
└── thematicworlds
    ├── ThematicWorld.java
    ├── ThematicWorldsService.java
    └── ThematicWorldsController.java
```

## ...

---
Happy Coding! 🚀

