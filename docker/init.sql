

CREATE TABLE if not exists Maps
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    image      bytea,
    visible    bool      DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP


);


CREATE TABLE if not exists Scenarios
(
    id          SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    description TEXT,
    mapid INT NOT NULL,
    FOREIGN KEY (mapid) REFERENCES Maps (id),
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE if not exists OldMaps
(
    id         SERIAL PRIMARY KEY,
    MapID      INT NOT NULL,
    FOREIGN KEY (MapID) REFERENCES Maps (id),
    DateOfMap  date,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


