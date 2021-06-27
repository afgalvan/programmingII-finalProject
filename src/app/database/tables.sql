CREATE TABLE users
(
    id                INTEGER NOT NULL PRIMARY KEY UNIQUE,
    name              TEXT    NOT NULL UNIQUE,
    type              TEXT,
    password          TEXT,
    salt              TEXT    NOT NULL,
    registration_date DATE DEFAULT (date ('now', 'localtime'))
)
