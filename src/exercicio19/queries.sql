-- Consultas solicitadas para o exercício 19

-- 1.a) Valor total dos produtos em estoque em ordem decrescente
SELECT 
    p.nome AS Produto,
    e.quantidade AS Quantidade,
    p.preco AS Preco_Unitario,
    (e.quantidade * p.preco) AS Valor_Total
FROM 
    produto p
    INNER JOIN estoque e ON p.id = e.id_produto
ORDER BY 
    Valor_Total DESC;

-- 1.b) Valor total dos produtos em estoque por filial em ordem decrescente
SELECT 
    f.nome AS Filial,
    f.cnpj AS CNPJ,
    SUM(e.quantidade * p.preco) AS Valor_Total_Estoque
FROM 
    filial f
    INNER JOIN estoque e ON f.cnpj = e.cnpj_filial
    INNER JOIN produto p ON e.id_produto = p.id
GROUP BY 
    f.cnpj, f.nome
ORDER BY 
    Valor_Total_Estoque DESC;

-- 2) Inserção de novos registros
INSERT INTO fornecedor (nome, telefone, endereco) VALUES
('Tech Solutions LTDA', '+55 (11) 9 9999-8888', 'Rua 7, n. 7, Tech Park'),
('Premium Goods S.A.', '+55 (21) 9 8888-7777', 'Rua 8, n. 8, Business Center');

INSERT INTO produto (id_fornecedor, nome, preco, validade) VALUES
(4, 'Notebook Premium', 5999.99, '2025-12-31'),
(4, 'Smartphone Pro', 4999.99, '2025-12-31'),
(5, 'Smart TV 65"', 6999.99, '2026-06-30'),
(5, 'Console Gaming Pro', 4599.99, '2026-06-30');

INSERT INTO identificacao (id, nome, descricao) VALUES
(10, 'premium', 'alta performance'),
(11, 'pro', 'uso profissional'),
(12, 'smart', '4K HDR'),
(13, 'gaming', 'última geração');

INSERT INTO estoque VALUES
(10, '01.678.277/0109-87', 5),
(11, '02.876.722/0202-55', 8),
(12, '03.987.311/0302-45', 3),
(13, '01.678.277/0109-87', 4);

-- 2) Consulta de filiais com valor total em estoque superior a R$ 10.000,00
SELECT 
    f.nome AS Filial,
    f.cnpj AS CNPJ,
    f.telefone AS Telefone,
    f.endereco AS Endereco,
    SUM(e.quantidade * p.preco) AS Valor_Total_Estoque
FROM 
    filial f
    INNER JOIN estoque e ON f.cnpj = e.cnpj_filial
    INNER JOIN produto p ON e.id_produto = p.id
GROUP BY 
    f.cnpj, f.nome, f.telefone, f.endereco
HAVING 
    Valor_Total_Estoque > 10000
ORDER BY 
    Valor_Total_Estoque DESC;