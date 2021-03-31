CREATE TABLE user (
    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
    name TEXT NOT NULL UNIQUE,
    type TEXT,
    password TEXT,
    registration_date DATE DEFAULT (date('now', 'localtime'))
)
