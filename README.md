# Spring Boot Backend

## 📌 Beschreibung
Diese Anwendung bildet das Backend für das Projekt „Alternativweltgeschichten“ des Stadtmuseums Olpe und fungiert als zentrale Schnittstelle zur Verwaltung und Bereitstellung der Themenwelten, die in den Besucher- und Mitarbeiter-Frontends verwendet werden. Über RESTful APIs ermöglicht das Backend die strukturierte Verwaltung von alten Karten und Szenarien, die als Grundlage für die Generierung neuer Alternativweltgeschichten im Besucher-Frontend dienen. Darüber hinaus übernimmt das Backend die Kommunikation mit dem angebundenen KI-Server zur Bildgenerierung: Es empfängt die Nutzereingaben aus dem Besucher-Frontend, leitet sie an den KI-Server weiter und übermittelt das generierte Bild zurück an das Frontend. Zusätzlich wird das für die Generierung im Besucher-Frontend verwendete KI-Modell gespeichert, um eine zentrale Steuerung zu ermöglichen.
Technologisch basiert die Anwendung auf Spring Boot und verwendet eine PostgreSQL-Datenbank zur Speicherung und Verwaltung der Themenwelten. Durch die Docker-Fähigkeit ist ein flexibler und skalierbarer Betrieb möglich. Zudem steht eine Swagger UI für die Dokumentation und das Testen der API-Endpunkte bereit.
Ziel dieser Anwendung ist es, eine zuverlässige, wartbare und erweiterbare Plattform zur Datenhaltung und Weiterverarbeitung zu bieten.

## 📖 Inhalt
- [Verwendete Technologien](#-verwendete-technologien)
- [Voraussetzungen](#%EF%B8%8F-voraussetzungen)
- [Installation und Setup](#-installation-und-setup)
- [API-Endpunkte](#-api-endpunkte)
- [Datenstruktur](#%EF%B8%8F-datenstruktur)
- [Projektstruktur](#-projektstruktur)

## 🚀 Verwendete Technologien
Dieses Projekt nutzt folgende Technologien und Frameworks:
- **Java** (Version: 17) – (Haupt)-Programmiersprache
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
Datenbank- und Anwendungseinstellungen in *application.properties* und *application.yml* anpassen.

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
- `GET /oldmaps/{id}/map` - Die Karte zu einer alten Karte abrufen
- `POST /oldmaps` - Eine alte Karte erstellen
- `PUT /oldmaps` - Eine alte Karte bearbeiten
- `DELETE /oldmaps/{id}` - Eine alte Karte anhand der ID löschen

### Prompting
- `POST /prompting/text` - Ein neues Bild aus Text generieren
- `POST /prompting/inpainting` - Ein neues Bild per Inpainting und Text generieren

### Scenarios
- `GET /scenarios` - Alle Szenarien abrufen
- `GET /scenarios/{id}` - Ein Szenario anhand der ID abrufen
- `GET /scenarios/{id}/map` - Die Karte zu einem Szenario abrufen
- `POST /scenarios` - Ein Szenario erstellen
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
Das Backend setzt eine relationale PostgreSQL-Datenbank ein, um alte Karten und Szenarien strukturiert zu speichern und zu verwalten. Diese Daten bilden die Grundlage für die im Besucher- und Mitarbeiter-Frontend dargestellten Themenwelten. Das zugrunde liegende Datenmodell folgt dabei den Prinzipien der Datenbank-Normalisierung, um eine konsistente, wartbare und redundanzfreie Datenhaltung sicherzustellen.

Die in der Datenbank gespeicherten Datensätze gliedern sich in zwei Kategorien:
- **Alte Karten (OldMap)** sind reale, historische Karten von Olpe. Sie sind unbearbeitet und dienen als authentische Grundlage für historische Bezüge und Vergleiche.
- **Szenarien (Scenario)** sind fiktive, alternative Darstellungen von Olpe. Sie entstehen aus Gedankenspielen und Überlegungen, wie die Stadt unter anderen historischen oder kulturellen Bedingungen ausgesehen haben könnte. Szenarien sind also Modifikationen auf Basis der alten Karten oder vollständig eigenständige Erfindungen.

**Themenwelten (ThematicWorld)** wiederum sind die für Besucher sichtbaren Einheiten. Sie werden nicht als eigene Entität in der Datenbank gespeichert, sondern dynamisch aus den vorhandenen Szenarien und alten Karten zusammengeführt. Dabei greift das Backend auf alle als sichtbar markierten alten Karten und Szenarien zu und kombiniert diese zu einer einheitlichen Liste von Themenwelten. Um die Darstellung für die Besucher möglichst intuitiv zu gestalten, ist die Liste der Themenwelten so sortiert, dass die aktuelle Karte von Olpe an erster Stelle steht, gefolgt von allen Szenarien in alphabetischer Reihenfolge und anschließend alle alten Karten, ebenfalls alphabetisch sortiert.
Durch diese einheitliche Zusammenführung von Karten und Szenarien in einer gemeinsamen Themenwelten-Liste müssen Besucher im Frontend nicht zwischen verschiedenen Bereichen oder Listen wechseln, sondern können alle relevanten Inhalte in übersichtlicher und gebündelter Form einsehen.

### Datenbankmodell
<img src="https://github.com/user-attachments/assets/57327479-1ce1-4916-bdbe-b74799075bd2" alt="Alt Text" width="600">

### Aufbau der Entitäten
**OldMap**
| Feldname     | Typ                  | Beschreibung                                    |
|--------------|----------------------|-------------------------------------------------|
| id           | Integer, Primary Key | Eindeutige Identifikation der Karte             |
| name         | Varchar(255)         | Name der historischen Karte                     |
| image        | Bytea                | Bild der Karte im Binärformat                   |
| date_of_map  | Text                 | Historisches Datum (z. B. Jahr oder Epoche)     |
| editable     | Boolean              | Gibt an, ob die Karte bearbeitet werden kann    |
| visible      | Boolean              | Gibt an, ob die Karte öffentlich sichtbar ist   |
| created_at   | Timestamp            | Erstellungsdatum                                |
| updated_at   | Timestamp            | Datum der letzten Aktualisierung                |

**Scenario**
| Feldname     | Typ                  | Beschreibung                                      |
|--------------|----------------------|---------------------------------------------------|
| id           | Integer, Primary Key | Eindeutige Identifikation des Szenarios           |
| name         | Varchar(255)         | Name des Szenarios                                |
| image        | Bytea                | Bild zum Szenario im Binärformat                  |
| description  | Text                 | Detaillierte Beschreibung und Kontext             |
| editable     | Boolean              | Gibt an, ob das Szenario bearbeitet werden kann   |
| visible      | Boolean              | Gibt an, ob das Szenario öffentlich sichtbar ist  |
| created_at   | Timestamp            | Erstellungsdatum                                  |
| updated_at   | Timestamp            | Datum der letzten Aktualisierung                  |

**ThematicWorld**
| Feldname     | Typ                  | Beschreibung                                        |
|--------------|----------------------|-----------------------------------------------------|
| id           | Integer, Primary Key | Eindeutige Identifikation der Themenwelt            |
| name         | Varchar(255)         | Name der Themenwelt                                 |
| description  | Text                 | Beschreibung mit historischen oder fiktiven Annahmen|
| image        | Bytea                | Bild zur Themenwelt im Binärformat                  |
| editable     | Boolean              | Gibt an, ob die Themenwelt bearbeitet werden kann   |
| visible      | Boolean              | Gibt an, ob die Themenwelt öffentlich sichtbar ist  |


## 🧱 Projektstruktur
Das Projekt folgt einem modularen Paket-Design, bei dem die Funktionalitäten in Domänen aufgeteilt und klar voneinander getrennt sind. Diese Struktur fördert Wartbarkeit, Erweiterbarkeit und eine klare Trennung der Verantwortlichkeiten.

### Übersicht über die Pakete
Das Projekt ist in folgende Domänenpakete unterteilt:
- **oldmaps**: Verwaltung von alten Karten
- **scenario**: Verwaltung von Szenarien
- **prompting**: Weiterleitung der Benutzereingaben zur Bildgenerierung
- **thematicworlds**: Verwaltung von thematischen Welten

Jedes Paket enthält spezifische Komponenten, um den *Clean Architecture-Ansatz* und die *Schichtenarchitektur (Layered Architecture)* umzusetzen.

### Aufbau der Schichten
Für jede Domäne (oldmaps, scenario, prompting, thematicworlds) sind die folgenden Schichten implementiert:

**Entity** (OldMap, Scenario, (ThematicWorld)):
  - Repräsentiert die Datenbankstruktur und spiegelt die Tabellen wider.
  - Verwendet JPA-Annotationen zur Definition von Persistenz-Mapping.
  - Wird für die Kommunikation mit der Datenbank verwendet.

**DTO** (OldMapDTO, ScenarioDTO, PromptingDTO):
  - Definiert die Datenstruktur für Anfragen und Antworten der REST-API.
  - Verhindert direkte Kopplung der Entitäten an externe Schnittstellen.

**Mapper** (OldMapMapper, ScenarioMapper):
  - Konvertiert zwischen Entity und DTO.
  - Verwendet MapStruct zur Generierung von Mapping-Code zur Compile-Zeit.

**Repository** (OldMapRepo, ScenarioRepo):
  - Schnittstelle zur Datenbankkommunikation mit Spring Data JPA.
  - Unterstützt CRUD-Operationen durch vordefinierte Methoden (findAll, findById, save, deleteById).

**Service** (OldMapService, ScenarioService, PromptingService, ThematicWorldsService):
  - Enthält die Geschäftslogik der Anwendung.
  - Koordiniert die Kommunikation zwischen Repository, Mapper und Controller.

**Controller** (OldMapController, ScenarioController, PromptingController, ThematicWorldsController):
  - Stellt die REST-API Endpunkte bereit.
  - Verarbeitet HTTP-Anfragen (GET, POST, PUT, DELETE) und gibt HTTP-Antworten zurück.
  - Delegiert die Geschäftslogik an den entsprechenden Service.

### Kommunikation zwischen den Schichten
- Der Controller empfängt die Anfragen und ruft die entsprechenden Methoden im Service auf.
- Der Service nutzt den Mapper, um die Daten zwischen DTO und Entity zu konvertieren und verwendet das Repository zur Datenbankkommunikation.
- Das Repository führt die CRUD-Operationen aus und gibt die Daten an den Service zurück.
- Der Service bereitet die Daten für den Controller auf, der sie als HTTP-Response zurückgibt.

### Vorteile und Begründung
- **Modularität**: Klare Trennung der Domänen (oldmaps, scenario, prompting, thematicworlds) erhöht die Übersichtlichkeit und fördert die Wartbarkeit.
- **Wiederverwendbarkeit und Testbarkeit**: Isolierte Geschäftslogik in den Services und wiederverwendbare Mapper erleichtern Unit-Tests.
- **Erweiterbarkeit**: Neue Features können durch Hinzufügen von Klassen in den jeweiligen Domänenpaketen leicht integriert werden.
- **Klarer Verantwortungsbereich**: Durch die Schichtenarchitektur bleibt der Code sauber und strukturiert.

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

