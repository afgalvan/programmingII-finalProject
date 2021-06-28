CREATE TABLE users
(
    id                INTEGER NOT NULL PRIMARY KEY UNIQUE,
    name              TEXT    NOT NULL UNIQUE,
    type              TEXT,
    password          TEXT,
    salt              TEXT    NOT NULL,
    registration_date DATE DEFAULT (date ('now', 'localtime'))
);

CREATE TABLE judicial_offices
(
    code       INTEGER NOT NULL PRIMARY KEY UNIQUE,
    name       TEXT    NOT NULL,
    department TEXT    NOT NULL,
    city       TEXT    NOT NULL,
    category   TEXT    NOT NULL
)
