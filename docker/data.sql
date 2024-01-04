CREATE DATABASE IF NOT EXISTS TICKETSYSTEM;

USE TICKETSYSTEM;

CREATE TABLE users(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age int NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tickets(
    id int NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    creator int NOT NULL,
    closed_by int,
    asignee int NOT NULL,
    status VARCHAR(255) NOT NULL,
    priority VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tags(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO users(name, age, email, password) VALUES ("Admin", 1, "admin@email.com", "admin");

INSERT INTO tickets(title, description, creator, asignee, status, priority) VALUES ("Test Ticket", "This is a default test ticket", 1, 1, "OPEN", "HIGH");