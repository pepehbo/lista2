-- Criação da tabela de produtos
CREATE TABLE produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10,2) NOT NULL,
    categoria VARCHAR(50)
);

-- Inserção de produtos para demonstração
INSERT INTO produto (nome, descricao, preco, categoria) VALUES
('Notebook Dell', 'Notebook Dell Inspiron 15', 3500.00, 'Eletrônicos'),
('iPhone 13', 'Smartphone Apple 128GB', 4999.99, 'Eletrônicos'),
('Monitor LG', 'Monitor 24 polegadas 144Hz', 899.99, 'Eletrônicos'),
('Teclado Mecânico', 'Teclado Gamer RGB', 299.99, 'Periféricos'),
('Mouse Gamer', 'Mouse 12000 DPI', 199.99, 'Periféricos'),
('MacBook Pro', 'MacBook Pro M1 Pro', 9999.99, 'Eletrônicos'),
('iPad Air', 'iPad Air 256GB', 4499.99, 'Eletrônicos'),
('AirPods Pro', 'Fone Bluetooth Apple', 1499.99, 'Eletrônicos'),
('Galaxy S21', 'Smartphone Samsung', 3999.99, 'Eletrônicos'),
('Xbox Series X', 'Console Microsoft', 4499.99, 'Eletrônicos');

-- a) Apresentando em ordem decrescente de preço
SELECT id, nome, descricao, preco
FROM produto
ORDER BY preco DESC;

-- b) Apresentando em ordem crescente de nome e decrescente de preço
SELECT id, nome, descricao, preco
FROM produto
ORDER BY nome ASC, preco DESC;

-- c) Agrupamento por categoria
SELECT categoria, COUNT(*) as quantidade
FROM produto
GROUP BY categoria;

-- d) Soma de preços por categoria
SELECT categoria, SUM(preco) as total
FROM produto
GROUP BY categoria;

-- e) Média de preços por categoria
SELECT categoria, AVG(preco) as media
FROM produto
GROUP BY categoria;

-- f) Soma de preços por categoria acima de R$ 100,00
SELECT categoria, SUM(preco) as total
FROM produto
GROUP BY categoria
HAVING total > 100;