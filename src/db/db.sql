/*
CREATE DATABASE sorteo;
-- USE SORTEO;
-- DROP DATABASE SORTEO;

CREATE TABLE usuario(
id_usuario INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(50),
username VARCHAR(50),
pass VARCHAR(30),
id_sorteo INT);

CREATE TABLE sorteo(
id_sorteo INT PRIMARY KEY AUTO_INCREMENT,
nombre_sorteo VARCHAR(40),
descripcion VARCHAR(200),
precio DOUBLE,
cantidad_rifas INT,
premio VARCHAR(40),
id_usuario INT,
id_premio INT);

CREATE TABLE premio(
id_premio INT PRIMARY KEY AUTO_INCREMENT,
premio VARCHAR(40),
id_sorteo INT);

-- INSERTIONS
INSERT INTO usuario(email, username, pass, id_sorteo) VALUES
("usuario1@prueba.com", "usuario1","pass", 1),
("usuario2@prueba.com", "usuario2","pass", 1),
("usuario3@prueba.com", "usuario3","pass", 1);

INSERT INTO sorteo(nombre_sorteo, descripcion, precio, cantidad_rifas, id_premio, id_usuario) VALUES
("Prueba uno", "Texto de prueba 1", 200.00, 100, 1, 1),
("Prueba dos", "Texto de prueba 2", 280.00, 60, 2, 2),
("Prueba tres", "Texto de prueba 3", 300.00, 150, 3, 3);

INSERT INTO premio(premio, id_sorteo) VALUES
("DINERO", 1),
("ELECTRODOMESTICO",2),
("ROPA",3);

-- ADD PKS AND FKS
ALTER TABLE usuario
ADD FOREIGN KEY (id_sorteo) REFERENCES sorteo(id_sorteo);

ALTER TABLE sorteo
ADD FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario);

ALTER TABLE premio
ADD FOREIGN KEY (id_sorteo) REFERENCES sorteo(id_sorteo);
*/