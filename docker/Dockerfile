# offizielle PostgreSQL-Image als Basis
FROM postgres:16

# Installieren von dos2unix um Zeilenumbrüche in das unix format umzuwandeln
RUN apt-get update && apt-get install -y dos2unix

# Umgebungsvariable für Postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=db

# Setzen des Arbeitsverzeichnisses im Container
WORKDIR /docker-entrypoint-initdb.d

# Dump in den Container kopieren
COPY init-db.sh tables.sql ./

# Skript ausführbar machen
RUN chmod +x init-db.sh && dos2unix init-db.sh


# PostgreSQL starten
CMD ["postgres"]
