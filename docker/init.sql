

CREATE TABLE if not exists Scenario
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    image       bytea,
    description TEXT,
    editable    BOOLEAN,
    visible     BOOLEAN,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE if not exists Old_Map
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    image       bytea,
    dateOfMap   TEXT,
    editable    BOOLEAN,
    visible     BOOLEAN,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


