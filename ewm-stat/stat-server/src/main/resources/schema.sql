CREATE TABLE IF NOT EXISTS HITS
(
    ID        INTEGER GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    APP       VARCHAR(64)                              NOT NULL,
    URI       VARCHAR(255)                             NOT NULL,
    IP        VARCHAR(64)                              NOT NULL,
    TIMESTAMP TIMESTAMP WITHOUT TIME ZONE              NOT NULL
);