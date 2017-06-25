CREATE TABLE customers (id SERIAL PRIMARY KEY, first_name VARCHAR(30), last_name VARCHAR(30));
CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));
