CREATE TABLE user (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name TEXT UNIQUE,
    password TEXT,
    registration_date DATE DEFAULT (date('now', 'localtime'))
)
