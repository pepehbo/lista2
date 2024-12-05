-- Criação das tabelas com relacionamento 1:1
CREATE TABLE cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(15)
);

CREATE TABLE endereco_cliente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT UNIQUE,
    rua VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado CHAR(2) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

-- Inserção de dados
INSERT INTO cliente (nome, email, telefone) VALUES
('João Silva', 'joao@email.com', '(11) 99999-9999'),
('Maria Santos', 'maria@email.com', '(11) 88888-8888'),
('Pedro Oliveira', 'pedro@email.com', '(11) 77777-7777'),
('Ana Costa', 'ana@email.com', '(11) 66666-6666'),
('Carlos Souza', 'carlos@email.com', '(11) 55555-5555');

INSERT INTO endereco_cliente (cliente_id, rua, numero, cidade, estado, cep) VALUES
(1, 'Rua A', '123', 'São Paulo', 'SP', '01234-567'),
(2, 'Rua B', '456', 'Rio de Janeiro', 'RJ', '12345-678'),
(3, 'Rua C', '789', 'Belo Horizonte', 'MG', '23456-789'),
(4, 'Rua D', '321', 'Curitiba', 'PR', '34567-890'),
(5, 'Rua E', '654', 'Porto Alegre', 'RS', '45678-901');

-- Consultas com ordenação
SELECT c.nome, c.email, e.cidade, e.estado
FROM cliente c
JOIN endereco_cliente e ON c.id = e.cliente_id
ORDER BY c.nome ASC;

-- Consultas com agrupamento
SELECT e.estado, COUNT(*) as quantidade_clientes
FROM cliente c
JOIN endereco_cliente e ON c.id = e.cliente_id
GROUP BY e.estado;

-- Consultas com condições sobre agrupamentos
SELECT e.estado, COUNT(*) as quantidade_clientes
FROM cliente c
JOIN endereco_cliente e ON c.id = e.cliente_id
GROUP BY e.estado
HAVING quantidade_clientes > 1;