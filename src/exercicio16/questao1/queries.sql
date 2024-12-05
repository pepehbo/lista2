-- Criação do banco de dados
CREATE DATABASE escola;
USE escola;

-- Criação das tabelas
CREATE TABLE aluno (
    matricula INT PRIMARY KEY AUTO_INCREMENT,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome VARCHAR(100) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone VARCHAR(15),
    endereco TEXT
);

CREATE TABLE curso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    valor_mensalidade DECIMAL(10,2) NOT NULL,
    data_criacao DATE NOT NULL
);

CREATE TABLE unidade_curricular (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    data_inicio DATE NOT NULL,
    data_termino DATE NOT NULL,
    carga_horaria INT NOT NULL
);

-- Operações CRUD para aluno
-- Create
INSERT INTO aluno (cpf, nome, data_nascimento, telefone, endereco)
VALUES 
('123.456.789-00', 'João Silva', '2000-01-15', '(11) 99999-9999', 'Rua A, 123'),
('987.654.321-00', 'Maria Santos', '1999-05-20', '(11) 88888-8888', 'Rua B, 456');

-- Read
SELECT * FROM aluno;
SELECT nome, cpf FROM aluno WHERE data_nascimento >= '2000-01-01';

-- Update
UPDATE aluno 
SET telefone = '(11) 77777-7777', endereco = 'Rua C, 789'
WHERE cpf = '123.456.789-00';

-- Delete
DELETE FROM aluno WHERE cpf = '987.654.321-00';

-- Operações CRUD para curso
-- Create
INSERT INTO curso (nome, descricao, valor_mensalidade, data_criacao)
VALUES 
('Análise e Desenvolvimento de Sistemas', 'Curso de tecnologia', 899.99, '2023-01-01'),
('Engenharia de Software', 'Curso de bacharelado', 1299.99, '2023-01-01');

-- Read
SELECT * FROM curso;
SELECT nome, valor_mensalidade FROM curso WHERE valor_mensalidade < 1000;

-- Update
UPDATE curso 
SET valor_mensalidade = 999.99
WHERE nome = 'Análise e Desenvolvimento de Sistemas';

-- Delete
DELETE FROM curso WHERE id = 2;

-- Operações CRUD para unidade curricular
-- Create
INSERT INTO unidade_curricular (nome, descricao, data_inicio, data_termino, carga_horaria)
VALUES 
('Programação Orientada a Objetos', 'Fundamentos de POO', '2024-02-01', '2024-06-30', 80),
('Banco de Dados', 'Modelagem e SQL', '2024-02-01', '2024-06-30', 60);

-- Read
SELECT * FROM unidade_curricular;
SELECT nome, carga_horaria FROM unidade_curricular WHERE carga_horaria > 60;

-- Update
UPDATE unidade_curricular 
SET carga_horaria = 100
WHERE nome = 'Programação Orientada a Objetos';

-- Delete
DELETE FROM unidade_curricular WHERE id = 2;