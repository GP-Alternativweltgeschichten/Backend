
DROP TABLE IF EXISTS Scenario CASCADE;
DROP TABLE IF EXISTS Old_Map CASCADE;


CREATE TABLE Scenario (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    image       bytea,
    description TEXT,
    editable    BOOLEAN,
    visible     BOOLEAN,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Old_Map (
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    image       bytea,
    date_of_map TEXT,
    editable    BOOLEAN,
    visible     BOOLEAN,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO Scenario (name, image, description, editable, visible)
VALUES
    ('Olpe heute',pg_read_binary_file('/res/olpe_default.png')::bytea, 'Aktuelle Karte von Olpe', TRUE, TRUE),
    ('ISEK Plan', pg_read_binary_file('/res/olpe_isek.png')::bytea,'Umsetzung des innerstädischen Entwicklungskonzepts', TRUE, TRUE),
    ('Überschwemmung', pg_read_binary_file('/res/olpe_uberflutet.png')::bytea,'Karte des überfluteten Gebiets von Olpe', TRUE, TRUE),
    ('Autogerechte Stadt', pg_read_binary_file('/res/olpe_auto.png')::bytea,'Karte des autogerechten Gebiets von Olpe', TRUE, TRUE);

INSERT INTO Old_Map (name, image, date_of_map, editable, visible)
VALUES
    ('Olpe damals', pg_read_binary_file('/res/olpe_1987.jpeg')::bytea,'1987', FALSE, TRUE);
