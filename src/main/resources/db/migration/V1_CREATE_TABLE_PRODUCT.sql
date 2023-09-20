--autor: Jose emanuel

CREATE TABLE product (
    idProduct UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255),
    description TEXT,
    price DECIMAL(10, 2) NOT NULL
);
