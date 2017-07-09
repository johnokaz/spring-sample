CREATE TABLE customers (id SERIAL PRIMARY KEY, first_name VARCHAR(30), last_name VARCHAR(30));
CREATE TABLE users (
    id SERIAL PRIMARY KEY, 
    username VARCHAR(30) NOT NULL, 
    encoded_password VARCHAR(255) NOT NULL, 
    firstname VARCHAR(30) NOT NULL,
    lastname VARCHAR(30) NOT NULL,
    mail VARCHAR(30) NOT NULL,
    last_login_on TIMESTAMP,
    created_on TIMESTAMP,
    updated_on TIMESTAMP
    );
