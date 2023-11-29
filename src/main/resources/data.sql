-- Inserção de dados na tabela cliente
INSERT INTO cliente (nome, endereco, telefone, uf, documento, email)
VALUES
('João Silva', 'Rua A, 123', '123456789', 'SP', '12345678901', 'joao@email.com'),
('Maria Oliveira', 'Avenida B, 456', '987654321', 'RJ', '98765432101', 'maria@email.com'),
('Carlos Santos', 'Praça C, 789', '111222333', 'MG', '11122233301', 'carlos@email.com');

-- Inserção de dados na tabela divida
INSERT INTO divida (codigo, credor_id, data_atualizacao, devedor_id, valor)
VALUES
(1, 1, '2023-11-29 10:00:00', 2, 1000.00),
(2, 2, '2023-11-28 12:30:00', 3, 1500.00),
(3, 3, '2023-11-27 15:45:00', 1, 800.00);

-- Inserção de dados na tabela pagamentos
INSERT INTO pagamentos (data_pagamento, valor_pago)
VALUES
('2023-11-29 11:00:00', 500.00),
('2023-11-28 14:00:00', 700.00),
('2023-11-27 16:30:00', 300.00);
