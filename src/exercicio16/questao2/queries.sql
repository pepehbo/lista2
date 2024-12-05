-- Criação do banco de dados
CREATE DATABASE oficina;
USE oficina;

-- Criação das tabelas
CREATE TABLE cliente (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(15),
    endereco TEXT
);

CREATE TABLE veiculo (
    chassi VARCHAR(17) PRIMARY KEY,
    placa VARCHAR(8) UNIQUE NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    ano INT NOT NULL
);

CREATE TABLE mecanico (
    cpf VARCHAR(14) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(15),
    endereco TEXT,
    salario DECIMAL(10,2) NOT NULL
);

-- Operações CRUD para cliente
-- Create
INSERT INTO cliente (cpf, nome, data_nascimento, telefone, endereco)
VALUES 
('123.456.789-00', 'Pedro Oliveira', '1985-03-10', '(11) 99999-9999', 'Rua X, 123'),
('987.654.321-00', 'Ana Santos', '1990-07-15', '(11) 88888-8888', 'Rua Y, 456');

-- Read
SELECT * FROM cliente;
SELECT nome, telefone FROM cliente WHERE data_nascimento >= '1990-01-01';

-- Update
UPDATE cliente 
SET telefone = '(11) 77777-7777', endereco = 'Rua Z, 789'
WHERE cpf = '123.456.789-00';

-- Delete
DELETE FROM cliente WHERE cpf = '987.654.321-00';

-- Operações CRUD para veículo
-- Create
INSERT INTO veiculo (chassi, placa, modelo, marca, ano)
VALUES 
('9BWZZZ377VT004251', 'ABC1234', 'Gol', 'Volkswagen', 2020),
('9BWZZZ377VT004252', 'DEF5678', 'Civic', 'Honda', 2021);

-- Read
SELECT * FROM veiculo;
SELECT modelo, marca, ano FROM veiculo WHERE ano >= 2020;

-- Update
UPDATE veiculo 
SET ano = 2022
WHERE placa = 'ABC1234';

-- Delete
DELETE FROM veiculo WHERE chassi = '9BWZZZ377VT004252';

-- Operações CRUD para mecânico
-- Create
INSERT INTO mecanico (cpf, nome, data_nascimento, telefone, endereco, salario)
VALUES 
('111.222.333-44', 'José Silva', '1980-05-20', '(11) 99999-1111', 'Rua M, 123', 3500.00),
('555.666.777-88', 'Carlos Santos', '1975-08-15', '(11) 99999-2222', 'Rua N, 456', 4000.00);

-- Read
SELECT * FROM mecanico;
SELECT nome, salario FROM mecanico WHERE salario > 3500;

-- Update
UPDATE mecanico 
SET salario = 3800.00
WHERE cpf = '111.222.333-44';

-- Delete
DELETE FROM mecanico WHERE cpf = '555.666.777-88';