CREATE DATABASE IF NOT EXISTS TICKETSYSTEM;

USE TICKETSYSTEM;

CREATE TABLE IF NOT EXISTS users(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age int NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tickets(
    id int NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    creator int NOT NULL,
    closed_by int,
    assignee int NOT NULL,
    status VARCHAR(255) NOT NULL,
    priority VARCHAR(255) NOT NULL,
    created_at VARCHAR(255) NOT NULL,
    deadline VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tags(
    id int NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tickets_tags(
    id int NOT NULL AUTO_INCREMENT,
    ticket_id int NOT NULL,
    tag_id int NOT NULL,
    PRIMARY KEY (id)
    );

INSERT INTO users(name, age, email, password) VALUES ("Admin", 1, "admin@email.com", "admin");

INSERT INTO tickets(title, description, creator, assignee, status, priority, created_at, deadline) VALUES ("Test Ticket", "This is a default test ticket", 1, 1, "OPEN", "HIGH", "05.01.2024", "11.01.2024");

INSERT INTO tags(name, color) VALUES ("Frontend", "#03fc90");

INSERT INTO tickets_tags(ticket_id, tag_id) VALUES (1, 1);