#!/bin/bash
set -e

echo "Starting to restore the dump..."

# Rollen erstellen, falls nicht vorhanden
echo "Check and create user 'postgres' if not exists"
psql -v ON_ERROR_STOP=1 -U "$POSTGRES_USER" -d "$POSTGRES_DB" <<-EOSQL
    DO \$\$
    BEGIN
        IF NOT EXISTS (SELECT 1 FROM pg_roles WHERE rolname = 'postgres') THEN
            CREATE ROLE postgres LOGIN PASSWORD 'postgres';
        END IF;
    END
    \$\$;
EOSQL

# Dump mit pg_restore einspielen
psql -U "$POSTGRES_USER" -d "$POSTGRES_DB" -1 /docker-entrypoint-initdb.d/tables.sql
echo "Dump has been restored."
