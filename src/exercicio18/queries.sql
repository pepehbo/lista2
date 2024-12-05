-- Consultas solicitadas para o exercício 18

-- 1.a) Soma dos preços dos produtos por fornecedor em ordem decrescente
SELECT 
    f.nome AS Fornecedor,
    SUM(p.preco) AS Total
FROM 
    fornecedor f
    INNER JOIN produto p ON f.id = p.id_fornecedor
GROUP BY 
    f.id, f.nome
ORDER BY 
    Total DESC;

-- 1.b) Média dos preços dos produtos por fornecedor em ordem decrescente
SELECT 
    f.nome AS Fornecedor,
    AVG(p.preco) AS Media
FROM 
    fornecedor f
    INNER JOIN produto p ON f.id = p.id_fornecedor
GROUP BY 
    f.id, f.nome
ORDER BY 
    Media DESC;

-- 2) Inserção de novos registros
INSERT INTO fornecedor (nome, telefone, endereco) VALUES
('Tech Solutions LTDA', '+55 (11) 9 9999-8888', 'Rua 4, n. 4, Vila Nova'),
('Moda Express S.A.', '+55 (21) 9 8888-7777', 'Rua 5, n. 5, Centro');

INSERT INTO produto (id_fornecedor, nome, preco, validade) VALUES
(4, 'notebook', 3499.99, '2025-12-31'),
(4, 'smartphone', 2499.99, '2025-12-31'),
(5, 'terno', 899.99, '2026-06-30'),
(5, 'blazer', 599.99, '2026-06-30');

INSERT INTO identificacao (id, nome, descricao) VALUES
(10, 'premium', 'alta performance'),
(11, 'avançado', 'última geração'),
(12, 'slim', 'corte moderno'),
(13, 'casual', 'uso diário');

-- 2) Consulta de fornecedores com soma de produtos maior que R$ 500,00
SELECT 
    f.nome AS Fornecedor,
    f.telefone AS Telefone,
    f.endereco AS Endereco,
    SUM(p.preco) AS Total
FROM 
    fornecedor f
    INNER JOIN produto p ON f.id = p.id_fornecedor
GROUP BY 
    f.id, f.nome, f.telefone, f.endereco
HAVING 
    SUM(p.preco) > 500
ORDER BY 
    Total DESC;