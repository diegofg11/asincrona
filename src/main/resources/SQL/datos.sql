-- Crear base de datos si no existe
CREATE DATABASE IF NOT EXISTS asincrona
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

-- Usar la base de datos
USE asincrona;

-- Eliminar la tabla si ya existía (opcional)
DROP TABLE IF EXISTS persona;

-- Crear la tabla persona
CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL
);

-- Insertar datos de ejemplo
INSERT INTO persona (nombre, apellido, fecha) VALUES
('Gabriel', 'Gutiérrez', '2001-01-16'),
('Mario', 'Fernández', '2007-02-08'),
('María', 'García', '1974-09-26'),
('Lucía', 'Pérez', '1998-04-12'),
('Andrés', 'Santos', '1989-10-05'),
('Claudia', 'Jiménez', '2000-07-22');
